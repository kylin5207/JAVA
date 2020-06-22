package dao.impl;

import dao.ItemsDao;
import domain.Items;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ItemsDaoImpl implements ItemsDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Items> findAll(){
        //使用jdbc操作数据库

        //1. 定义sql
        String sql = "select * from items";
        List<Items> items = template.query(sql, new BeanPropertyRowMapper<Items>(Items.class));

        return items;
    }

}
