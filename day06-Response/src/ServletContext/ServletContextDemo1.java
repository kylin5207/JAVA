package ServletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ServletContext:
 *     代表整个web应用，可以和程序的容器(服务器)来通信
 */

@WebServlet("/servletContextDemo1")
public class ServletContextDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //ServletContext对象的获取方式，两种方式获取的对象是一样的

        //1. 可以通过request对象获取
        ServletContext context1 = request.getServletContext();

        //2. 通过HttpServlet获取
        ServletContext context2 = this.getServletContext();

        if(context1 == context2) {
            // 结果是True
            System.out.println("True");
        }
        else {
            System.out.println("False");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
