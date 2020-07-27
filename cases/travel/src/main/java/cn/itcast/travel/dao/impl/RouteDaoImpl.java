package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.RouteDao;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class RouteDaoImpl implements RouteDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    /**
     * 查询总记录数
     * @param cid
     * @return
     */
    @Override
    public int findTotalCount(int cid, String rname) {
        //1. 定义sql模版
        String sql = "select count(*) from tab_route where 1=1 ";
        StringBuilder sb = new StringBuilder(sql);

        List params = new ArrayList(); // 条件

        //2. 判断参数是否有值
        if(cid != 0){
            sb.append(" and cid = ? ");
            params.add(cid); // 添加？对应的值
        }

        if(rname != null && !("null").equals(rname) && rname.length() > 0){
            sb.append("and rname like ?");
            params.add("%"+rname+"%");
        }

        sql = sb.toString();
        System.out.println(sql);
        System.out.println(params.toString());
//        String sql = "select count(*) from tab_route where cid = ?";

        return template.queryForObject(sql, Integer.class, params.toArray());
    }


    @Override
    public List<Route> findByPage(int cid, int start, int pageSize, String rname) {
        //1. 定义sql模版
        String sql = "select * from tab_route where 1=1 ";
        StringBuilder sb = new StringBuilder(sql);

        List params = new ArrayList(); // 条件

        if(cid != 0){
            sb.append("and cid = ? ");
            params.add(cid);
        }

        if(rname != null && !("null").equals(rname) && rname.length()>0){
            sb.append("and rname like ? ");
            params.add("%"+rname+"%");
        }

        sb.append(" limit ? , ?");
        params.add(start);
        params.add(pageSize);

        sql = sb.toString();
        System.out.println(sql);
        System.out.println(params.toString());

//        String sql = "select * from tab_route where cid = ? limit ? , ?";
        return template.query(sql, new BeanPropertyRowMapper<Route>(Route.class), params.toArray());
    }

    /**
     * 根据rid查询route对象
     * @param rid
     * @return
     */
    @Override
    public Route findOne(int rid) {
        String sql = "select * from tab_route where rid = ?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<Route>(Route.class), rid);
    }

    /**
     * 根据rname查询排行情况
     * @param start
     * @param pageSize
     * @param rname
     * @return
     */
    @Override
    public List<Route> findRankByPage(int start, int pageSize, String rname) {
        //1. 定义sql模版
        String sql = "select * from tab_route where 1=1 ";
        StringBuilder sb = new StringBuilder(sql);

        List params = new ArrayList(); // 条件

        if(rname != null && !("null").equals(rname) && rname.length()>0){
            sb.append("and rname like ? ");
            params.add("%"+rname+"%");
        }

        sb.append("order by count desc limit ? , ?");
        params.add(start);
        params.add(pageSize);

        sql = sb.toString();
        System.out.println(sql);
        System.out.println(params.toString());

        return template.query(sql, new BeanPropertyRowMapper<Route>(Route.class), params.toArray());
    }

}
