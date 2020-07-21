package cn.itcast.travel.service;

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
}
