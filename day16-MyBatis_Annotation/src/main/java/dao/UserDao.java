package dao;

import domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 用户——数据访问层接口
 */
public interface UserDao {

    /**
     * 查找所有用户
     * @return
     */
    @Select("select * from user")
    List<User> findAll();
}
