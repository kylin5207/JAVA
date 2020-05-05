package Servlet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 *GenericServlet将Servlet接口中的其他方法做了默认空实现，只将service方法()作为抽象
 * （但是一般不使用）
 */
@WebServlet("/GenericServlet")
public class GenericServletDemo extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("GenericServlet");
    }
}
