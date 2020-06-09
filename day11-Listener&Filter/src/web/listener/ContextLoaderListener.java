package web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.http.WebSocket;

/**
 * Listener监听器
 */

@WebListener
public class ContextLoaderListener implements ServletContextListener {

    /**
     * 监听ServletContext对象创建，服务器启动后自动创建，自动调用
     * @param servletContextEvent
     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        // 一般用于加载资源文件
        //1. 获取ServletContext对象
        ServletContext servletContext = servletContextEvent.getServletContext();

        //2. 加载资源文件
        String contextConfigLocation = servletContext.getInitParameter("contextConfigLocation");

        //3. 获取真实路径
        String realpath = servletContext.getRealPath(contextConfigLocation);

        //4. 加载进内存
        try {
            FileInputStream fs = new FileInputStream(realpath);
            System.out.println(fs);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("ServletContext对象被创建了");
    }

    /**
     * 服务器正常关闭后，该方法被调用
     * @param servletContextEvent
     */
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("ServletContext对象被销毁");
    }
}
