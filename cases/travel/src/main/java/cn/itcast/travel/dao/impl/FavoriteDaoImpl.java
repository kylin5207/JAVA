package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.FavoriteDao;
import cn.itcast.travel.domain.Favorite;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class FavoriteDaoImpl implements FavoriteDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    /**
     * 根据rid和uid查询收藏信息
     * @param rid
     * @param uid
     * @return
     */
    @Override
    public Favorite findByRidAndUid(int rid, int uid) {
        Favorite favorite = null;
        try{
            String sql = "select * from tab_favorite where rid = ? and uid = ?";

            favorite = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Favorite>(Favorite.class), rid, uid);

        }
        catch (DataAccessException e){
            e.printStackTrace();
        }
        return favorite;
    }
}
