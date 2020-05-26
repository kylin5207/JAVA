package VerificationCode.servlet;

import VerificationCode.dao.UserDao;
import VerificationCode.domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * 用户登录案例需求：
 * 	1.编写login.html登录页面
 * 		username & password 两个输入框
 * 	2.使用Druid数据库连接池技术,操作mysql，db1数据库中USER表
 * 	3.使用JdbcTemplate技术封装JDBC
 * 	4.登录成功跳转到SuccessServlet展示：登录成功！用户名,欢迎您
 * 	5.登录失败跳转到FailServlet展示：登录失败，用户名或密码错误
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 设置编码
        request.setCharacterEncoding("UTF-8");

        //2. 获取所有请求参数
        Map<String, String[]> map =  request.getParameterMap();
        User loginUser = new User();

        //3. 使用BeanUtils封装
        try {
            BeanUtils.populate(loginUser, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println(loginUser);

        //4. 判断验证码是否正确
        String checkcode_session = (String) request.getSession().getAttribute("checkcode_session");
        request.getSession().removeAttribute("checkcode_session"); // 获取之后立即删除，以避免验证码的二次使用
        if(checkcode_session != null && checkcode_session.equalsIgnoreCase(map.get("checkcode")[0])){
            // 忽略大小写比较验证码字符串
            //5. 调用UserDao
            UserDao dao = new UserDao();
            User user = dao.login(loginUser);

            if(user == null) {
                //登陆失败
                request.setAttribute("login_error", "username or password error");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
            else{
                //登陆成功
                request.getSession().setAttribute("username", user.getUsername());
                response.sendRedirect(request.getContextPath()+"/success.jsp");
            }

        }
        else{
            // 验证码错误
            request.setAttribute("checkcode_error", "checkcode error");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}

