package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/findUserServlet")
public class FindUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 获取用户名
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");

        Map<String, Object> map = new HashMap<String, Object>();
        String msg;
        System.out.println(username);

        response.setContentType("text/html;charset=utf-8");

        //2. 调用service层判断用户名是否存在
        if("YSL".equals(username)){
            //存在
            msg = "🙅此用户名太受欢迎，请换一个吧";
            map.put("userExist", true);
            map.put("msg", msg);
        }
        else{
            //不存在
            msg = "✅";
            map.put("userExist", false);
            map.put("msg", msg);
        }

        //3. 将map转换为Json
        ObjectMapper mapper = new ObjectMapper();
        //将数据传递给客户端
        mapper.writeValue(response.getWriter(), map);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
