package web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * 敏感词汇过滤器
 */
@WebFilter("/*")
public class SensitiveWordsFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        //1. 创建代理对象，增强getParameter方法
        req.setCharacterEncoding("utf-8");
        ServletRequest proxy_request = (ServletRequest) Proxy.newProxyInstance(req.getClass().getClassLoader(), req.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                //增强getParameter方法，判断是否是getParameter方法
                if(method.getName().equals("getParameter")){
                    //增强返回值
                    //获取返回值
                    String value = (String) method.invoke(req, objects);
                    if(value != null){
                        for (String s : list) {
                            if(value.contains(s)){
                                value = value.replaceAll(s, "***");
                            }
                        }
                    }
                    return value;
                }
                else{
                    return method.invoke(req, objects);
                }
            }
        });


        //2. 放行

        chain.doFilter(proxy_request, resp);
    }

    private List<String> list = new ArrayList<String>(); // 敏感词汇list集合
    public void init(FilterConfig config) throws ServletException {

        try{
            // 1. 加载敏感词汇文件
            ServletContext servletContext = config.getServletContext();
            String realPath = servletContext.getRealPath("/WEB-INF/classes/敏感词汇.txt");

            // 2. 读取文件，获取数据
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(realPath), "GBK"));

            // 3. 将文件的每一行数据添加到list中
            String line = null;
            while((line = br.readLine())!=null){
                list.add(line);
            }
            br.close();
            System.out.println(list);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

}
