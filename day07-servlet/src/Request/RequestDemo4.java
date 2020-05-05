package Request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * 获取请求参数通用方式:不论get还是post请求方式都可以使用下列方法来获取请求参数
 * String getParameter(String name):根据参数名称获取参数值,只能获取一个
 * String[] getParameterValues(String name):根据参数名称获取参数值的数组 hobby=xx&hobby=game
 * Enumeration<String> getParameterNames():获取所有请求的参数名称
 * Map<String,String[]> getParameterMap():获取所有参数的map集合
 */
@WebServlet("/RequestDemo4")
public class RequestDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //post 获取请求参数
        //根据请求参数对值，获取参数值
        String username = request.getParameter("username");
        System.out.println("username = " + username);

        //根据参数，获取值的数组
        String[] hobbies = request.getParameterValues("hobby");
        for (String hobby : hobbies) {
            System.out.println(hobby);
        }

        //获取所有请求的参数名称
        Enumeration<String> hobbiesName = request.getParameterNames();
        while (hobbiesName.hasMoreElements()) {
            String name = hobbiesName.nextElement();
            String[] value = request.getParameterValues(name);
            System.out.println(name + " = " + Arrays.toString(value));
        }

        //获取所有参数的map集合
        Map<String, String[]> map = request.getParameterMap();
        Set<String> set = map.keySet();
        for (String s : set) {
            String[] values = map.get(s);
            System.out.println(s + " = " + Arrays.toString(values));
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get 获取请求参数
        this.doPost(request, response);
    }
}