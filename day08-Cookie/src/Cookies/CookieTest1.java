package Cookies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Cookie:
 *      客户端会话技术，将数据保存到客户端
 * 1. 创建Cookie对象，绑定数据
 *    new Cookie(String name, String value)
 * 2. 发送Cookie对象
 *    一次可以发送多个Cookie
 *    response.addCookie(Cookie cookie)
 * 3. 获取Cookie，拿到数据
 *    Cookie[] request.getCookies()
 */
@WebServlet("/cookieTest1")
public class CookieTest1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 创建Cookie对象，绑定数据
        Cookie c1= new Cookie("msg", "Hello");
        Cookie c2 = new Cookie("msg2", "message2");


        //2. 发送Cookie对象
        response.addCookie(c1);
        response.addCookie(c2);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
