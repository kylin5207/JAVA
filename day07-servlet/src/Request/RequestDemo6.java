package Request;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 请求转发：
 *      一种在服务器内部的资源跳转方式
 * 特点:
 *  1. 浏览器地址栏路径不发生变化
 *  2. 只能转发到当前服务器内部资源中。
 *  3. 转发是一次请求
 *
 *
 *  在request域中共享数据
 */
@WebServlet("/RequestDemo6")
public class RequestDemo6 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("访问RequestDemo6");

        //存储数据到Request域中
        request.setAttribute("msg", "Hello,Kylin");

        //将资源转发到RequestDemo62
        //通过request对象获取请求转发器对象，之后利用forward转发
        request.getRequestDispatcher("/RequestDemo62").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
