package FileDownLoadCase;

import utils.DownLoadUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 文件下载案例的Servlet类
 *
 * 存在的问题：中文文件名问题
 *    1. 获取客户端使用的浏览器版本信息
 *    2. 根据不同的版本信息，设置filename的编码方式
 */
@WebServlet("/downloadServlet")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 获取文件名称
        String filename = request.getParameter("filename");

        //2. 使用字节输入流加载文件进内存
        //2.1 找到文件的服务器路径
        ServletContext context = this.getServletContext();
        String realpath = context.getRealPath("/image/"+filename);

        //2.2 用字节流关联
        FileInputStream fis = new FileInputStream(realpath);

        //3. 指定response的响应头
        //3.1 content-type
        String realmime = context.getMimeType(filename); //获取文件的MIME类型
        response.setHeader("content-type", realmime);

        //3.2.1 解决中文文件名问题
        String agent = request.getHeader("user-agent");
        //3.2.2 使用工具类DownLoadUtils根据不同的浏览器将文件名进行编码处理
        filename = DownLoadUtils.getFileName(agent, filename);

        //3.3 content-disposition:attachment;filename=xxx;
        response.setHeader("content-disposition", "attachment;filename="+filename);

        //4. 将数据写出到response的输出流
        ServletOutputStream sos = response.getOutputStream();
        byte[] buff = new byte[1024 * 8];
        int len = 0;
        while ((len = fis.read(buff)) != -1) {
            sos.write(buff, 0, len);
        }

        fis.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
