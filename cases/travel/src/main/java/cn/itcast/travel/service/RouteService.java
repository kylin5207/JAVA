package cn.itcast.travel.service;

import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;

/**
 * 路线service
 */
public interface RouteService {
    //根据类别进行分页查询
    public PageBean<Route> pageQuery(int cid, int currentPage, int pageSize);
}
