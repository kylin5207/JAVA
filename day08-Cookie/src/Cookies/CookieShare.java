package Cookies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Cookie共享
 * 1. 在一个服务器中，部署多个项目，这些项目中的Cookie是否可以共享？
 *     1. 默认情况下，Cookie不能共享
 *     2. setPath(String path):设置cookie的获取范围。默认情况下，设置当前虚拟目录。
 * 2. 不同的tomcat服务器间cookie共享问题?
 *      * setDomain(String path):如果设置一级域名相同，那么多个服务器之间cookie可以共享
 *        比如setDomain(".baidu.com"),那么news.baidu.com和tieba.baidu.com中的Cookie可以共享
 */

@WebServlet("/cookieShare")
public class CookieShare extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 创建Cookies对象
        Cookie c1 = new Cookie("msg", "Cookie共享");

        // 2. 设置path，共享Cookie信息
        c1.setPath("/");

        // 3. 发送Cookie
        response.addCookie(c1);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
