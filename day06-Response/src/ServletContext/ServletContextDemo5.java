package ServletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 *ServletContext功能3：
 *     获取文件的服务器路径
 *
 *String getRealPath(String path)："/文件名"
 */
@WebServlet("/servletContextDemo5")
public class ServletContextDemo5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = this.getServletContext();

        //对应web目录下的资源路径
        String path = context.getRealPath("/b.txt");
        System.out.println(path);

        //WEB-INF下的a.txt文件
        String path2 = context.getRealPath("/WEB-INF/a.txt");
        System.out.println(path2);

        //src目录下的c.txt文件
        String path3 = context.getRealPath("/WEB-INF/classes/c.txt");
        System.out.println(path3);

        File file = new File(path);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
