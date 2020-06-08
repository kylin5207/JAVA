package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Filter生命周期
 *
 */
//@WebFilter("/*")
public class FilterDemo3 implements Filter {

    /**
     * 在服务器器关闭后，Filter对象被销毁。如果服务器是正常关闭，则会执行destroy方法。只执⾏一次。
     * 用于释放资源
     */
    public void destroy() {
        System.out.println("Do destroy");
    }

    /**
     *每⼀次请求被拦截资源时，会执⾏。执行多次
     * @param req
     * @param resp
     * @param chain
     * @throws ServletException
     * @throws IOException
     */
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("Do filter...");
        chain.doFilter(req, resp);

    }

    /**
     * 在服务器器启动后，会创建Filter对象，然后调⽤init方法。只执行⼀次。
     * ⽤于加载资源
     * @param config
     * @throws ServletException
     */
    public void init(FilterConfig config) throws ServletException {
        System.out.println("Do init...");
    }

}
