package web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 完成登陆验证的过滤器
 *
 * 注意排除掉js、图片、验证码等资源
 */
@WebFilter("/*")
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        // 0. 强制转换
        HttpServletRequest request = (HttpServletRequest) req;

        // 1. 判断是否登陆相关的资源
        // 1.1 获取请求的资源路径
        String uri = request.getRequestURI();
        if(uri.contains("/login.jsp") || uri.contains("/loginServlet") || uri.contains("/css") || uri.contains("/fonts") || uri.contains("/js") || uri.contains("/checkCodeServlet")){
            // 包含，表示用户需要登陆，则放行
            chain.doFilter(req, resp);
        }
        else{
            //2. 不包含，则需要验证用户是否登陆
            //2.1 从Session中获取user
            Object user = request.getSession().getAttribute("user");
            if(user != null){
                // 表示用户已经登陆，则放行
                chain.doFilter(req, resp);
            }
            else{
                //没有登陆，则跳转登陆页面
                request.setAttribute("login_msg", "您尚未登陆，请先登陆");
                request.getRequestDispatcher("/login.jsp").forward(request,resp);
            }
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
