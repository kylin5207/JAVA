package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.FavoriteDao;
import cn.itcast.travel.domain.Favorite;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Override
    public int findCountByRid(int rid) {
        String sql = "select count(*) from tab_favorite where rid = ?";

        return jdbcTemplate.queryForObject(sql, Integer.class, rid);
    }

    @Override
    public void add(int rid, int uid) {
        String sql = "insert into tab_favorite values(?,?,?)";
        jdbcTemplate.update(sql, rid, new Date(), uid);
    }

    /**
     * 根据uid查询用户收藏的路线数
     * @param uid
     * @return
     */
    @Override
    public int findCountByUid(int uid) {
        //1. 定义sql模版
        String sql = "select count(*) from tab_favorite where uid = ? ";

        return jdbcTemplate.queryForObject(sql, Integer.class, uid);
    }

    /**
     * 根据uid，start和pageSize获取用户收藏的路线列表
     * @param uid
     * @param start
     * @param pageSize
     * @return
     */
    @Override
    public List<Route> findByPage(int uid, int start, int pageSize) {
        //1. 定义sql模版
        String sql = "select * from tab_route where rid in (select rid from tab_favorite where uid = ?) limit ?,?";

        System.out.println(sql);

//        String sql = "select * from tab_route where cid = ? limit ? , ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Route>(Route.class), uid, start, pageSize);
    }
}
