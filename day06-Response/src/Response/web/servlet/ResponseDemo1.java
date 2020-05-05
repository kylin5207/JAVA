package Response.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 重定向案例：
 *     一种资源跳转的方式
 *
 * 重定向redirect的特点:
 * 1. 地址栏发生变化
 * 2. 重定向可以访问其他站点(服务器)的资源
 * 3. 重定向是两次请求。不能使用request对象来共享数据
 *
 *
 */

@WebServlet("/responseDemo1")
public class ResponseDemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //访问/responseDemo1资源，会自动跳转到/responseDemo2资源
        System.out.println("responseDemo1被访问");

        //这种方法写起来比较复杂
//        // 1. 设置状态码
//        response.setStatus(302);
//
//        // 2. 设置响应头
//        response.setHeader("location", "/Response/responseDemo2");

        // 简单的重定向方法，注意最好不要把路径写死，使用虚拟目录动态获取
        String path = request.getContextPath() + "/responseDemo2";
        response.sendRedirect(path);

        //可以重定向到其他网站
//        response.sendRedirect("http://www.baidu.com");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
