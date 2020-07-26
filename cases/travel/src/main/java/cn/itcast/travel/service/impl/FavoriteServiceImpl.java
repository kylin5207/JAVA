package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.FavoriteDao;
import cn.itcast.travel.dao.impl.FavoriteDaoImpl;
import cn.itcast.travel.domain.Favorite;
import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.service.FavoriteService;

import java.util.List;

public class FavoriteServiceImpl implements FavoriteService {
    private FavoriteDao favoriteDao = new FavoriteDaoImpl();
    /**
     * 用户是否收藏rid标记的路线
     * @param rid
     * @param uid
     * @return
     */
    @Override
    public boolean isFavorite(int rid, int uid) {
        Favorite favorite = favoriteDao.findByRidAndUid(rid, uid);
        if(favorite != null){
            //如果查询到了，表示收藏过
            return true;
        }
        else{
            //否则，没有收藏过
            return false;
        }
    }

    /**
     * 添加收藏
     * @param rid
     * @param uid
     */
    @Override
    public void add(int rid, int uid) {
        favoriteDao.add(rid, uid);
    }


    /**
     * 根据uid进行收藏路线分页查询
     * @param uid
     * @param currentPage
     * @param pageSize
     * @return
     */
    public PageBean<Route> FavoritePageQuery(int uid, int currentPage, int pageSize){
        PageBean<Route> pb = new PageBean<Route>();

        //设置pagebean的相关信息
        pb.setCurrentPage(currentPage);
        int totalCount = favoriteDao.findCountByUid(uid);
        System.out.println(totalCount);
        pb.setTotalCount(totalCount);

        int start = (currentPage-1) * pageSize;
        List<Route> list = favoriteDao.findByPage(uid, start, pageSize);
        pb.setList(list);

        pb.setPageSize(pageSize);

        int totalPage = totalCount % pageSize == 0? totalCount/pageSize : (totalCount/pageSize)+1;
        pb.setTotalPage(totalPage);

        return pb;
    }
}
