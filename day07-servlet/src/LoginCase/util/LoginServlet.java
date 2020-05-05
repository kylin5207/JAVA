package LoginCase.util;

import org.apache.commons.beanutils.BeanUtils;
import LoginCase.dao.UserDao;
import LoginCase.domain.User;

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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 设置编码
        req.setCharacterEncoding("UTF-8");

//        //2. 获取请求参数
//        String username = req.getParameter("username");
//        String password = req.getParameter("pwd");
//
//        System.out.println("pwd: " + password);
//
//        //3. 封装User对象
//        User loginUser = new User();
//        loginUser.setUsername(username);
//        loginUser.setPwd(password);

        //2. 获取所有请求参数
        Map<String, String[]> map =  req.getParameterMap();
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

        //4. 调用UserDao
        UserDao dao = new UserDao();
        User user = dao.login(loginUser);

        if(user == null) {
            //登陆失败
            req.getRequestDispatcher("failServlet").forward(req, resp);
        }
        else{
            //登陆成功
            req.setAttribute("user", user);
            req.getRequestDispatcher("successServlet").forward(req, resp);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
