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
 *
 * Filter拦截方式配置：资源被访问的方式
 * 注解配置：
 * 设置dispatcherTypes属性
 * 1. REQUEST:默认值。浏览器器直接请求资源
 * 2. FORWARD:转发访问资源
 * 3. INCLUDE:包含访问资源
 * 4. ERROR:错误跳转资源
 * 5. ASYNC:异步访问资源
 * 设置多种拦截方式时，使用{}包裹即可
 *
 */
@WebFilter(value="/Hello.jsp", dispatcherTypes = {DispatcherType.FORWARD, DispatcherType.REQUEST})
public class FilterDemo implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("Filter do...");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
