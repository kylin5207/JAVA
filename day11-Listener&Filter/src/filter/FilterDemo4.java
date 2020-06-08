package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Filter的拦截路径配置
 * 1. 具体资源路径: "/index.jsp"
 * 2. 拦截目录："/user/*"访问user目录下的都会被执行
 * 3. 后缀名拦截："*.jsp"访问所有后缀名为jsp资源时，过滤器都会被执行
 * 4. 拦截所有资源："/*"
 */
//@WebFilter("/Hello.jsp")
@WebFilter("*.jsp")
public class FilterDemo4 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("Filter do...");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
