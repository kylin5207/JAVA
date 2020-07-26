package cn.itcast.travel.service;

import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;

public interface FavoriteService {
    /**
     * 判断uid是否收藏rid的路线
     * @param rid
     * @param uid
     * @return
     */
    public boolean isFavorite(int rid, int uid);

    /**
     * 添加收藏
     * @param rid
     * @param uid
     */
    public void add(int rid, int uid);

    /**
     * 根据我的收藏进行分页显示
     * @param uid
     * @param currentPage
     * @param pageSize
     * @return
     */
    public PageBean<Route> FavoritePageQuery(int uid, int currentPage, int pageSize);
}
