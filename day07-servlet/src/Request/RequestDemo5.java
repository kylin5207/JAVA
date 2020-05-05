package Request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RequestDemo5")
public class RequestDemo5 extends HttpServlet {
    //post方式会出现乱码
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 在获取参数前，设置request的编码方式
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("username");
        System.out.println(name);
    }

    //Tomcat8将get方式的乱码解决了
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get 获取请求参数
        this.doPost(request, response);
    }
}
