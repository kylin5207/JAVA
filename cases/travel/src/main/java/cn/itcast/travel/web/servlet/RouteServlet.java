package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.service.RouteService;
import cn.itcast.travel.service.impl.RouteServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/route/*")
public class RouteServlet extends BaseServlet {
    private RouteService routeService = new RouteServiceImpl();

    /**
     * 分页查询
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void pageQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 接受参数
        String currentPagestr = request.getParameter("currentPage");
        String pageSizestr = request.getParameter("pageSize");
        String cidstr = request.getParameter("cid");

        //接收rname参数
        String rname = request.getParameter("rname");

        //处理参数
        int currentPage = 1;
        if (currentPagestr != null && currentPagestr.length() > 0) {
            currentPage = Integer.parseInt(currentPagestr);
        }

        int pageSize = 5;
        if (pageSizestr != null && pageSizestr.length() > 0) {
            pageSize = Integer.parseInt(pageSizestr);
        }

        int cid = 0;
        if (cidstr != null && cidstr.length() > 0 && !"null".equals(cidstr)) {
            cid = Integer.parseInt(cidstr);
        }

        //2. 调用service查询PageBean对象
        PageBean<Route> route = routeService.pageQuery(cid, currentPage, pageSize, rname);
        //3. 将PageBean序列化为json并返回
        this.writeValue(route, response);

    }

    /**
     * 根据id查询一个旅游线路详情
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 接收rid
        String rid = request.getParameter("rid");

        //2. 调用service查询route对象
        Route route = routeService.findOne(Integer.parseInt(rid));

        //3. 转为json写入客户端
        this.writeValue(route, response);

    }
}