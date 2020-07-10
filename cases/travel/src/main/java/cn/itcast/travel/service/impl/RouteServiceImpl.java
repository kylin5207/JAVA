package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.RouteDao;
import cn.itcast.travel.dao.impl.RouteDaoImpl;
import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.service.RouteService;

import java.util.List;

public class RouteServiceImpl implements RouteService {
    RouteDao routeDao = new RouteDaoImpl();
    /**
     * 封装PageBean并返回
     * @param cid
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public PageBean<Route> pageQuery(int cid, int currentPage, int pageSize) {
        PageBean<Route> pb = new PageBean<Route>();

        //设置pagebean的相关信息
        pb.setCurrentPage(currentPage);
        int totalCount = routeDao.findTotalCount(cid);
        pb.setTotalCount(totalCount);

        int start = (currentPage-1) * pageSize;
        List<Route> list = routeDao.findByPage(cid, start, pageSize);
        pb.setList(list);

        pb.setPageSize(pageSize);

        int totalPage = totalCount % pageSize == 0? totalCount/pageSize : (totalCount/pageSize)+1;
        pb.setTotalPage(totalPage);

        return pb;
    }
}
