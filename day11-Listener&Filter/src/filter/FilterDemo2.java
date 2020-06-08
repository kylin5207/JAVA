package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class FilterDemo2 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //对request对象请求消息增强
        System.out.println("FilterDemo2 ...");
        //放行
        chain.doFilter(req, resp);
        //对response对象的响应消息增强
        System.out.println("FilterDemo2 comes back");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
