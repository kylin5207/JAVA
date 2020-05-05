package Response.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *Response案例2：服务器输出字符数据到浏览器
 */

@WebServlet("/responseDemo4")
public class ResponseDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 在获取流对象之前，设置流的默认编码
        response.setCharacterEncoding("UTF-8");

        // 2. 服务器发送的消息体数据的编码格式
        response.setContentType("text/html;charset=UTF-8");

        // 3. 获取输出流对象
        PrintWriter pw = response.getWriter();

        // 4. 输出数据
        pw.write("苏伊士运河");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
