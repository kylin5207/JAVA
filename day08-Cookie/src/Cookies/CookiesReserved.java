package Cookies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Cookie生命周期：
 * 1. 默认情况下，Cookie当浏览器关闭后，其中的数据就被摧毁
 * 2. 持久化存储：
 *      setMaxAge(int seconds)
 *             1. 正数:将Cookie数据写到硬盘的⽂件中。持久化存储。seconds指定cookie存活时间，时间到后，cookie⽂件自动失效
 *             2. 负数:默认值
 *             3. 零:删除cookie信息
 */

@WebServlet("/cookiesReserved")
public class CookiesReserved extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 创建Cookies对象
        Cookie c1 = new Cookie("msg", "setMaxAge");

        // 2. 设置生存时间
        c1.setMaxAge(30); //将cookie持久化到硬盘，30s后自动删除该cookie

        // 3. 发送Cookie
        response.addCookie(c1);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
