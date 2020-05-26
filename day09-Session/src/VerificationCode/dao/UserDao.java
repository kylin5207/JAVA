package VerificationCode.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import VerificationCode.domain.User;
import VerificationCode.utils.JDBCUtils;

/**
 * 用于操作数据库中USER表的类
 */

public class UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    /**
     * 登陆方法
     * @param loginUser 包含用户名和密码
     * @return 封装好的User对象
     */
    public User login(User loginUser) {
        try{
            // 1. 编写sql
            String sql = "select * from USER where username = ? and pwd = ?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(), loginUser.getPwd());

            return user;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
}
