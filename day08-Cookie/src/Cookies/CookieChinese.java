package Cookies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Cookie中文存储
 * 1. 在tomcat8之前 cookie中不能直接存储中⽂数据
 *     可以使用URL编码
 * 2.在tomcat8之后，cookie⽀持中文数据。特殊字符还是不⽀支持，建议使用URL编码存储，URL解码解析
 */

@WebServlet("/cookieChinese")
public class CookieChinese extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 创建Cookies对象
        Cookie c1 = new Cookie("msg", "帅琦，你好");

        // 2. 发送Cookie
        response.addCookie(c1);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
