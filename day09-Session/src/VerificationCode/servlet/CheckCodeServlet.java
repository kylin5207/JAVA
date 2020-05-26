package VerificationCode.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * 验证码生成Servlet
 */
@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int width = 100;
        int height = 50;

        // 1. 创建一对象，在内存中绘图
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        // 2. 美化图片
        // 2.1 填充背景色
        Graphics g = image.getGraphics(); // 画笔对象
        g.setColor(Color.pink); // 设置画笔颜色
        g.fillRect(0, 0, width, height);

        // 2.2 绘制边框
        g.setColor(Color.BLUE);
        g.drawRect(0, 0, width-1, height-1);

        // 2.3 写验证码
        // 所有可能出现的字符
        String str = "ABCDEFGHIGKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        // 生成随机角标
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < 5; i++) {
            int index = random.nextInt(str.length());
            char ch = str.charAt(index);
            sb.append(ch);
            g.drawString(ch + "", width/5 * i, height/2);
        }

        String checkCode_session = sb.toString();
        // 将验证码存入Session
        request.getSession().setAttribute("checkcode_session", checkCode_session);

        // 2.4 加干扰线
        int linelength = random.nextInt(10);
        g.setColor(Color.GREEN);
        for (int i = 0; i < linelength; i++) {
            int x1 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int x2 = random.nextInt(width);
            int y2 = random.nextInt(height);
            g.drawLine(x1, y1, x2, y2);
        }


        // 3. 将图片输出到页面展示
        ImageIO.write(image, "jpg", response.getOutputStream());

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
