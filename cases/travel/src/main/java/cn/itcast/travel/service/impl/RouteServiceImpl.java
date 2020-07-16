package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.RouteDao;
import cn.itcast.travel.dao.RouteImgDao;
import cn.itcast.travel.dao.SellerDao;
import cn.itcast.travel.dao.impl.RouteDaoImpl;
import cn.itcast.travel.dao.impl.RouteImgDaoImpl;
import cn.itcast.travel.dao.impl.SellerDaoImpl;
import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.domain.RouteImg;
import cn.itcast.travel.domain.Seller;
import cn.itcast.travel.service.RouteService;

import java.util.List;

public class RouteServiceImpl implements RouteService {
    private RouteDao routeDao = new RouteDaoImpl();
    private RouteImgDao routeImgDao = new RouteImgDaoImpl();
    private SellerDao sellerDao = new SellerDaoImpl();

    /**
     * 封装PageBean并返回
     * @param cid
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public PageBean<Route> pageQuery(int cid, int currentPage, int pageSize, String rname) {
        PageBean<Route> pb = new PageBean<Route>();

        //设置pagebean的相关信息
        pb.setCurrentPage(currentPage);
        int totalCount = routeDao.findTotalCount(cid, rname);
        pb.setTotalCount(totalCount);

        int start = (currentPage-1) * pageSize;
        List<Route> list = routeDao.findByPage(cid, start, pageSize, rname);
        pb.setList(list);

        pb.setPageSize(pageSize);

        int totalPage = totalCount % pageSize == 0? totalCount/pageSize : (totalCount/pageSize)+1;
        pb.setTotalPage(totalPage);

        return pb;
    }

    /**
     * 根据rid查询目标路线详情
     * @param rid
     * @return
     */
    @Override
    public Route findOne(int rid) {

        //1. 根据rid去route表中查询对象
        Route route = routeDao.findOne(rid);


        //2. 根据rid查询图片列表信息
        List<RouteImg> routeImglist = routeImgDao.findByRid(rid);
        route.setRouteImgList(routeImglist);

        //3. 根据route的rid查询seller，即sid
        Seller seller = sellerDao.findById(route.getSid());
        //设置seller对象
        route.setSeller(seller);

        return route;
    }
}
