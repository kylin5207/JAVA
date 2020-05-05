package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * HttpServlet是对http协议的一种封装，简化操作
 * 1. 定义类继承HttpServlet类
 * 2. 重写doGet和doPost方法
 */
@WebServlet({"/HttpServlet", "/Demo1"})
public class HttpServletDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //默认使用get方法
        System.out.println("Do get...");
        System.out.println("Method : " + req.getMethod());
        System.out.println("虚拟目录 : " + req.getContextPath());
        System.out.println("Servlet路径 : " + req.getServletPath());
        System.out.println("获取get方式的请求参数 : " + req.getQueryString());
        System.out.println("统一资源标识符URI : " + req.getRequestURI());
        System.out.println("统一资源定位符URL : " + req.getRequestURL());
        System.out.println("用户ip : " + req.getRemoteAddr());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Do post...");
        System.out.println(req);
    }
}
