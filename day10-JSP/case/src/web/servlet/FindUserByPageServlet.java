package web.servlet;

import domain.PageBean;
import domain.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/findUserByPageServlet")
public class FindUserByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 获取参数
        String _currentPage = request.getParameter("currentPage"); //当前页码
        String _rows = request.getParameter("rows"); //每页显示的条数

        if(_currentPage == null || "".equals(_currentPage)){

            _currentPage = "1";
        }
        if(_rows == null || "".equals(_rows)){
            _rows = "5";
        }


        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);

        if(currentPage < 1){
            currentPage = 1;
        }

        //2. 调用Service查询
        UserService service = new UserServiceImpl();
        PageBean<User> pb = service.findUserByPage(currentPage, rows);

        //3. 将PageBean存入request
        request.setAttribute("pb", pb);

        //4. 转发到List.jsp
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
