package VerificationCode.servlet;

import VerificationCode.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/successServlet")
public class SuccessServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取Request域中共享的对象
        User user = (User) req.getAttribute("user");

        if (user != null) {
            resp.setContentType("text/html; charset=utf-8");
            resp.getWriter().write("登陆成功" + user.getUsername() + "欢迎您");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
