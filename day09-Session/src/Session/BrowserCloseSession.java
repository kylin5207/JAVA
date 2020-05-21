package Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * 当客户端关闭后，服务器不关闭，两次获取session是否为同一个?
 *
 * 默认情况下，客户端关闭后，会话结束，索引session并不是同一个。
 *  如果需要相同，则可以创建Cookie,键为JSESSIONID，设置最大存活时间，让cookie持久化保存
 */

@WebServlet("/browserCloseSession")
public class BrowserCloseSession extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 获取Session
        HttpSession session = request.getSession();

        // 2. 期望客户端关闭后，Session也能相同
        Cookie cookie = new Cookie("JSESSIONID", session.getId());
        cookie.setMaxAge(60*60);
        response.addCookie(cookie);

        // 3. 打印Session
        System.out.println(session);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
