package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class FilterDemo4 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("FilterDemo4 do...");
        chain.doFilter(req, resp);
        System.out.println("FilterDemo4 comes back...");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
