package Cookies;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 案例:记住上⼀次访问时间
 * 1. 需求:
 *    1. 访问⼀个Servlet，如果是第⼀次访问，则提示:您好，欢迎您首次访问。
 *    2. 如果不是第一次访问，则提示:欢迎回来，您上次访问时间为:显示时间字符串
 * 2. 分析:
 *    1. 可以采⽤用Cookie来完成
 *    2. 在服务器中的Servlet判断是否有一个名为lastTime的cookie
 *       1. 有:不是第一次访问，写回Cookie
 *       2. 没有：是第一次访问
 *             1. 响应数据：您好，欢迎您首次访问
 *             2. 写回Cookie: lastTime = 时间
 */

@WebServlet("/cookieCase")
public class CookieCase extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 设置响应的消息题的数据格式以及编码
        response.setContentType("text/html;charset=utf-8");

        // 1. 获取所有Cookie
        boolean flag = false; // 是否找到目标cookie标记
        Cookie[] cookies = request.getCookies();

        // 2. 遍历Cookie数组
        if(cookies != null && cookies.length > 0) {
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if("lastTime".equals(name)) {
                    // 证明有该Cookie，表示不是第一次访问

                    // 1. 获取cookie对应的value值
                    String value = cookie.getValue();
                    // 解码，目前是utf-8编码的数据
                    System.out.println("解码前的数据：" + value);
                    value = URLDecoder.decode(value, "utf-8");
                    System.out.println("解码后的数据：" + value);

                    // 2. 设置新时间
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    String newvalue = sdf.format(date);
                    System.out.println("时间编码前的数据：" + newvalue);

                    //对新value值进行URL编码
                    newvalue = URLEncoder.encode(newvalue, "utf-8");
                    System.out.println("编码后的数据：" + newvalue);

                    // 3. 设置新cookie
                    cookie.setValue(newvalue);
                    response.addCookie(cookie);
                    // 4. 设置Cookie存活时间
                    cookie.setMaxAge(60*60*24*30);

                    // 5. 响应数据信息
                    response.getWriter().write("<h1>欢迎回来，您上次访问时间为:" + value + "<h1>");
                    flag = true;
                    break;
                }
            }
        }

        if(cookies == null || cookies.length == 0 || flag == false) {
            // 1. 获取时间
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            String value = sdf.format(date);

            // 2. 对时间数据进行编码处理，不然会报错
            System.out.println("时间编码前的数据：" + value);
            value = URLEncoder.encode(value, "utf-8");
            System.out.println("编码后的数据：" + value);

            // 3. 设置cookie数据
            Cookie cookie = new Cookie("lastTime", value);

            cookie.setMaxAge(60*60*24*30);
            response.addCookie(cookie);

            // 4. 响应数据信息
            response.getWriter().write("<h1>您好，欢迎您首次访问<h1>");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
