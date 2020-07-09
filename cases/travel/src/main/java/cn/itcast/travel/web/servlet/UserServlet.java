package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.ResultInfo;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.service.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/user/*") // user/find user/add都可匹配
public class UserServlet extends BaseServlet {
    //声明一个成员变量service
    private UserService service = new UserServiceImpl();

    //注册用户
    public void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //检验验证码是否输入正确
        String check = request.getParameter("check");

        HttpSession session = request.getSession();

        String code = (String) session.getAttribute("CHECKCODE_SERVER");

        //移除session中的验证码，保证验证码只能使用一次
        session.removeAttribute("CHECKCODE_SERVER");
        System.out.println("servercode = " + code);
        System.out.println("code = " + check);

        //比较
        if (code == null || !(code.equalsIgnoreCase(check))) {
            //验证码校验失败
            ResultInfo resultInfo = new ResultInfo();
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("验证码输入错误");

            //将resultInfo序列化为json，并返回客户端
            this.writeValue(resultInfo, response);
//            ObjectMapper mapper = new ObjectMapper();
//            String json = mapper.writeValueAsString(resultInfo);
//
//
//            //将json数据写回客户端
//            //设置contentType
//            response.setContentType("application/json;charset=utf-8");
//            response.getWriter().write(json);

            return;
        }

        //1. 获取数据
        Map<String, String[]> map = request.getParameterMap();

        //2. 封装对象
        User user = new User();
        try {
            BeanUtils.populate(user, map);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //3. 使用service完成注册
//        UserService service = new UserServiceImpl();
        boolean flag = service.regist(user);
        ResultInfo resultInfo = new ResultInfo();
        //4. 响应结果
        if (flag) {
            //注册成功
            resultInfo.setFlag(true);
        } else {
            //注册失败
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("注册失败！");

        }

        //4. 将resultInfo序列化为json，并返回客户端
        this.writeValue(resultInfo, response);
//        ObjectMapper mapper = new ObjectMapper();
//        String json = mapper.writeValueAsString(resultInfo);
//
//        //将json数据写回客户端
//        //设置contentType
//        response.setContentType("application/json;charset=utf-8");
//        response.getWriter().write(json);
    }

    //登陆功能
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //检验验证码是否输入正确
        String check = request.getParameter("check");

        HttpSession session = request.getSession();

        String code = (String) session.getAttribute("CHECKCODE_SERVER");

        //移除session中的验证码，保证验证码只能使用一次
        session.removeAttribute("CHECKCODE_SERVER");
        System.out.println("servercode = " + code);
        System.out.println("code = " + check);

        //比较
        if (code == null || !(code.equalsIgnoreCase(check))) {
            //验证码校验失败
            ResultInfo resultInfo = new ResultInfo();
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("验证码输入错误");

            //将resultInfo序列化为json，并返回客户端
//            ObjectMapper mapper = new ObjectMapper();
//            String json = mapper.writeValueAsString(resultInfo);


            //将json数据写回客户端
            //设置contentType
            this.writeValue(resultInfo, response);
//            response.setContentType("application/json;charset=utf-8");
//            response.getWriter().write(json);
            return;
        }

        // 1. 获取用户名和密码数据
        Map<String, String[]> map = request.getParameterMap();

        // 2. 封装User对象
        User loginuser = new User();
        try {
            BeanUtils.populate(loginuser, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        // 3. 调用Service查询
//        UserService service = new UserServiceImpl();
        User user = service.login(loginuser);

        ResultInfo resultInfo = new ResultInfo();
        // 4. 判断用户名密码是否正确
        if (user == null) {
            //用户信息错误
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("用户名或密码错误～");
        } else {
            //判断用户是否激活
            if (!"Y".equals(user.getStatus())) {
                //用户未激活
                resultInfo.setFlag(false);
                resultInfo.setErrorMsg("您尚未激活，请登陆邮箱激活");
            } else {
                //登陆成功
                resultInfo.setFlag(true);
                session.setAttribute("user", user);
            }
        }

        //响应数据
//        ObjectMapper mapper = new ObjectMapper();
//        response.setContentType("application/json;charset=utf-8");
//        mapper.writeValue(response.getOutputStream(), resultInfo);
        this.writeValue(resultInfo, response);
    }

    //查找单个用户
    public void findOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Object user = request.getSession().getAttribute("user");

        //将这个username写会客户端
        this.writeValue(user,response);
//
//        ObjectMapper mapper = new ObjectMapper();
//        response.setContentType("application/json;charset=utf-8");
//        mapper.writeValue(response.getOutputStream(), user);
    }

    //用户退出功能
    public void exit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //销毁Session
        request.getSession().invalidate();

        //2. 跳转页面
        response.sendRedirect(request.getContextPath() + "/index.html");
    }

    //用户激活
    public void active(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取激活码
        String code = request.getParameter("code");

        if(code != null){
            //调用service完成激活
//            UserService service = new UserServiceImpl();
            boolean flag = service.active(code);

            String msg = null;
            //判断标记
            if(flag){
                //激活成功
                msg = "激活成功，请<a href='login.html'>登陆</a>";
            }
            else{
                //激活失败
                msg = "激活失败，请联系管理员!";
            }
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(msg);
        }
    }
}