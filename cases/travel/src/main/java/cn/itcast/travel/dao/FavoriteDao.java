package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Favorite;
import cn.itcast.travel.domain.Route;

import java.util.List;

public interface FavoriteDao {
    /**
     * 查询数据库中favorite表是否存在rid和uid
     * @param rid
     * @param uid
     * @return
     */
    public Favorite findByRidAndUid(int rid, int uid);

    /**
     * 根据rid查询收藏次数
     * @param rid
     * @return
     */
    public int findCountByRid(int rid);

    /**
     * 添加收藏
     * @param rid
     * @param uid
     */
    public void add(int rid, int uid);

    /**
     * 根据uid查询我的收藏
     * @param cid
     * @return
     */
    public int findCountByUid(int cid);

    /*
        根据uid, start, pageSize查询当前页的数据集合
     */
    public List<Route> findByPage(int cid, int start, int pageSize);

}
