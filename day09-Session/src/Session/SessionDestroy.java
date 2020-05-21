package Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * session什么时候被销毁?
 * 1. 服务器关闭
 * 2. session对象调用invalidate()。
 * 3. session默认失效时间30分钟
 */
@WebServlet("/sessionDestroy")
public class SessionDestroy extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 获取Session
        HttpSession session = request.getSession();

        // 2. 销毁Session
        session.invalidate();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
