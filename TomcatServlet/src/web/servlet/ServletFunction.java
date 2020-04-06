package web.servlet;

import javax.servlet.*;
import java.io.IOException;

public class ServletFunction implements Servlet {
    /**
     * 初始化方法：
     * 在Servlet被创建时执行，只执行一次
     * 可以指定Servlet的创建时机
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("========init Servlet==========");
    }

    /**
     * 获取ServletConfig对象
     * Servlet的配置对象
     * @return
     */
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 提供服务的方法：
     * 每次访问Servlet都会执行，可执行多次
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("--------service()方法执行--------");
    }

    /**
     * 获取Servlet的一些信息：
     *  版本、作者等
     * @return
     */
    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * 在Servlet被销毁时，即服务器关闭时执行
     * 只有服务器正常关闭时，才会执行destroy方法
     * 只执行一次
     */
    @Override
    public void destroy() {
        System.out.println("==========destroy==========");
    }
}
