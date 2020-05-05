package Request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/RequestDemo2")
public class RequestDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取用户浏览器版本
        String agent = request.getHeader("user-agent");

        // 判断浏览器版本
        if(agent.contains("Chrome")) {
            System.out.println("谷歌");
        }
        else if(agent.contains("Firefox")) {
            System.out.println("火狐");
        }
        else if(agent.contains("Safari")) {
            System.out.println("苹果浏览器");
        }
    }
}
