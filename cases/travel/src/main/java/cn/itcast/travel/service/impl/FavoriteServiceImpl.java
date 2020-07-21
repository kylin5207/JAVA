package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.FavoriteDao;
import cn.itcast.travel.dao.impl.FavoriteDaoImpl;
import cn.itcast.travel.domain.Favorite;
import cn.itcast.travel.service.FavoriteService;

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
}
