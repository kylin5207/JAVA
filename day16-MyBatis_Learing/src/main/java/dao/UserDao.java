package dao;

import domain.User;

import java.util.List;

/**
 * 用户——数据访问层接口
 */
public interface UserDao {

    /**
     * 查找所有用户
     * @return
     */
    List<User> findAll();

    /**
     * 保存用户
     * @param user
     */
    void saveUser(User user);
}
