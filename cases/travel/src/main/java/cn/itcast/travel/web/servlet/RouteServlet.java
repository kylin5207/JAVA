package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.FavoriteService;
import cn.itcast.travel.service.RouteService;
import cn.itcast.travel.service.impl.FavoriteServiceImpl;
import cn.itcast.travel.service.impl.RouteServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/route/*")
public class RouteServlet extends BaseServlet {
    private RouteService routeService = new RouteServiceImpl();
    private FavoriteService favoriteService = new FavoriteServiceImpl();

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
        System.out.println("rname:" + rname);

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
     *
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

    /**
     * 判断当前用户收否收藏该线路
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public void isFavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 获取线路id
        String ridStr = request.getParameter("rid");
        User user = (User) request.getSession().getAttribute("user");
        int uid;
        int rid;
        if (user == null) {
            //用户未登陆
            uid = 0;
        } else {
            //用户已经登陆
            uid = user.getUid();
        }

        if (ridStr == null) {
            //如果rid=null，对其进行处理
            rid = 0;
        } else {
            rid = Integer.parseInt(ridStr);
        }

        //2. 调用FavoriteService查询rid和uid的关系
        boolean flag = favoriteService.isFavorite(rid, uid);
        writeValue(flag, response);
    }

    /**
     * 添加收藏
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void addFavorite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 获取线路id和用户id
        String ridStr = request.getParameter("rid");
        User user = (User) request.getSession().getAttribute("user");
        int uid; //存放用户id
        int rid;
        if (user == null || ridStr == null) {
            //用户未登陆或路线id未知
            return;
        } else {
            //用户已经登陆
            rid = Integer.parseInt(ridStr);
            uid = user.getUid();
        }

        //2. 调用service添加
        favoriteService.add(rid, uid);
    }


    /**
     * 我的收藏分页查询
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void FavoritePageQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 接受参数
        String currentPagestr = request.getParameter("currentPage");
        String pageSizestr = request.getParameter("pageSize");
        User user = (User) request.getSession().getAttribute("user");
        int uid = user.getUid();

        //处理参数
        int currentPage = 1;
        if (currentPagestr != null && currentPagestr.length() > 0) {
            currentPage = Integer.parseInt(currentPagestr);
        }

        int pageSize = 8;
        if (pageSizestr != null && pageSizestr.length() > 0) {
            pageSize = Integer.parseInt(pageSizestr);
        }

        //2. 调用service查询PageBean对象
        PageBean<Route> route = favoriteService.FavoritePageQuery(uid, currentPage, pageSize);
        //3. 将PageBean序列化为json并返回
        this.writeValue(route, response);

    }

    /**
     * 路线排行分页查询
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void RankPageQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. 接受参数
        String currentPagestr = request.getParameter("currentPage");
        String pageSizestr = request.getParameter("pageSize");
        String cidstr = request.getParameter("cid");
        String rname = request.getParameter("rname");

        int cid = 0;
        if (cidstr != null && cidstr.length() > 0 && !"null".equals(cidstr)) {
            cid = Integer.parseInt(cidstr);
        }

        //处理参数
        int currentPage = 1;
        if (currentPagestr != null && currentPagestr.length() > 0) {
            currentPage = Integer.parseInt(currentPagestr);
        }

        int pageSize = 8;
        if (pageSizestr != null && pageSizestr.length() > 0) {
            pageSize = Integer.parseInt(pageSizestr);
        }

        //2. 调用service查询PageBean对象
        PageBean<Route> route = routeService.RankPageQuery(cid, currentPage, pageSize, rname);
        //3. 将PageBean序列化为json并返回
        this.writeValue(route, response);

    }

}