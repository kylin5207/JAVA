package cn.itcast.travel.web.servlet;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Servlet优化
 * 减少Servlet的数量，现在是一个功能一个Servlet，将其优化为一个模块一个Servlet.
 * 相当于在数据库中一张表对应一个Servlet
 * 在Servlet中提供不同的方法，完成用户的请求
 */


public class BaseServlet extends HttpServlet {

    protected void service(HttpServletRequest req, HttpServletResponse resp) {
//        System.out.println("BaseServlet的service方法被执行");

        // 完成方法分发

        // 1. 获取请求路径
        String uri = req.getRequestURI();
        System.out.println("请求路径：" + uri);

        // 2. 获取方法名称
        String methodName = uri.substring(uri.lastIndexOf("/")+1);
        System.out.println("方法名：" + methodName);

        // 3. 获取方法对象
        try {
            // getDeclaredMethod()方法忽略访问权限修饰符，获取方法
//            Method method = this.getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
//            // 4. 执行方法
//            //method.setAccessible(true); 暴力反射
            Method method = this.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);

            method.invoke(this, req, resp);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }

    /**
     * 直接将传入的数据对象序列化为json，并且写回客户端
     * @param obj
     */
    public void writeValue(Object obj, HttpServletResponse resp) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        resp.setContentType("application/json;charset=utf-8");
        objectMapper.writeValue(resp.getOutputStream(), obj);
    }

    /**
     * 将传入的数据序列化为json字符串，并返回
     * @param obj
     * @return string
     */
    public String writeValueAsString(Object obj) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return  mapper.writeValueAsString(obj);
    }

}
