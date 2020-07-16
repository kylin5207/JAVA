package cn.itcast.travel.dao;

import cn.itcast.travel.domain.RouteImg;

import java.util.List;

public interface RouteImgDao {

    /**
     * 根据线路rid查找对应的图片列表
     * @param rid
     * @return
     */
    public List<RouteImg> findByRid(int rid);
}
