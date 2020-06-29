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

@WebServlet("/registUserServlet")
public class RegistUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //检验验证码是否输入正确
        String check = request.getParameter("check");

        HttpSession session = request.getSession();

        String code = (String) session.getAttribute("CHECKCODE_SERVER");

        //移除session中的验证码，保证验证码只能使用一次
        session.removeAttribute("CHECKCODE_SERVER");
        System.out.println("servercode = " + code);
        System.out.println("code = " + check);

        //比较
        if(code == null || !(code.equalsIgnoreCase(check))){
            //验证码校验失败
            ResultInfo resultInfo = new ResultInfo();
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("验证码输入错误");

            //将resultInfo序列化为json，并返回客户端
            ObjectMapper mapper = new ObjectMapper();
            String json = mapper.writeValueAsString(resultInfo);


            //将json数据写回客户端
            //设置contentType
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(json);
            return;
        }

        //1. 获取数据
        Map<String, String[]> map = request.getParameterMap();

        //2. 封装对象
        User user = new User();
        try {
            BeanUtils.populate(user, map);
        }
        catch (Exception e){
            e.printStackTrace();
        }

        //3. 嗲用service完成注册
        UserService service = new UserServiceImpl();
        boolean flag = service.regist(user);
        ResultInfo resultInfo = new ResultInfo();
        //4. 响应结果
        if(flag){
            //注册成功
           resultInfo.setFlag(true);
        }
        else {
            //注册失败
            resultInfo.setFlag(false);
            resultInfo.setErrorMsg("注册失败！");

        }

        //4. 将resultInfo序列化为json，并返回客户端
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(resultInfo);

        //将json数据写回客户端
        //设置contentType
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
