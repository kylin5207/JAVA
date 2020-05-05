package ServletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ServletContext功能1：
 *   获取MIME类型:
 *       MIME类型:在互联网通信过程中定义的一种文件数据类型
 *       格式: 大类型/小类型 text/html image/jpeg
 *
 *   获取方法:String getMimeType(String file)
 */

@WebServlet("/servletContextDemo2")
public class ServletContextDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext context = this.getServletContext();

        // 定义一个文件名称
        String filename = "pic.jpg";

        // 获取文件对应的MIME类型
        String Mimetype = context.getMimeType(filename);
        System.out.println("文件" + filename + "对应的MIME类型：" + Mimetype);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
