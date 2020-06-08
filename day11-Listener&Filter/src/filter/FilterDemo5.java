package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class FilterDemo5 implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("FilterDemo5 do...");
        chain.doFilter(req, resp);
        System.out.println("FilterDemo5 comes back...");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
