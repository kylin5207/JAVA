package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.UserDao;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public User findByUsername(String username) {
        User user;
        try{
            //1. 定义sql语句
            String sql = "select * from tab_user where username = ?";

            //2. 执行sql
            user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username);
            System.out.println(user);
        }
        catch (Exception e){
            user = null;
        }

        return user;
    }

    @Override
    public void save(User user) {
        //1. 定义插入sql
        String sql = "insert into tab_user(username, password, name, birthday, sex, telephone, email) values(?, ?, ?, ?, ?, ?, ?)";

        //2. 执行sql
        jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getName(), user.getBirthday(), user.getSex(), user.getTelephone(), user.getEmail());

    }
}
