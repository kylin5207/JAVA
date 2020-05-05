package Request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Enumeration;

@WebServlet("/loginServlet01")
public class LoginServlet01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Do get...");
        System.out.println("==========请求行数据============");
        System.out.println("Method : " + request.getMethod());
        System.out.println("虚拟目录 : " + request.getContextPath());
        System.out.println("Servlet路径 : " + request.getServletPath());
        System.out.println("获取get方式的请求参数 : " + request.getQueryString());
        System.out.println("统一资源标识符URI : " + request.getRequestURI());
        System.out.println("统一资源定位符URL : " + request.getRequestURL());
        System.out.println("协议及版本 : " + request.getProtocol());
        System.out.println("用户ip : " + request.getRemoteAddr());

        System.out.println("==========请求头数据===========");
        Enumeration<String> headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()){

            String name = headerNames.nextElement();
            String value = request.getHeader(name);
            System.out.println(name + " : " + value);
        }

        String referer = request.getHeader("referer");
        if(referer.contains("localhost")) {
            System.out.println("查看字符编码格式：" + Charset.defaultCharset());
            //发现是UTF-8格式
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write("正常访问");
            System.out.println("正常访问");
        }
        else{
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write("非法访问");
            System.out.println("非法访问");
        }
    }
}
