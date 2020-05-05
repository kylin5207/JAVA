package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 路径定义规则：
 * 可以使用通配符*
 *  注意：这种方式的优先级最低
 */
//@WebServlet("/HttpServlet/*")
    @WebServlet("*.do") // 前面不用带/
public class HttpServletDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //默认使用get方法
        System.out.println("Do get...");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Do post...");
    }
}
