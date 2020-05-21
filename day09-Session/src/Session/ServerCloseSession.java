package Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 客户端不关闭，服务器关闭后，两次获取的session是同一个吗?
 * 不是同⼀个，但是要确保数据不丢失。tomcat自动完成以下工作，idea不能这样，需要手动进行
 *      session的钝化（序列化过程）:
 * *         在服务器正常关闭之前，将session对象系列化到硬盘上
 * *     session的活化（反序列化过程）:
 * *         在服务器启动后，将session⽂件转化为内存中的session对象即可。
 *
 */
@WebServlet("/serverCloseSession")
public class ServerCloseSession extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
