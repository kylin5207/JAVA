package cn.itcast.travel.dao;

import cn.itcast.travel.domain.User;

public interface UserDao {
    /**
     * 根据用户名查询用户信息
     * @return User
     */
    public User findByUsername(String username);

    /**
     * 用户信息保存
     * @param user 用户类
     */
    public void save(User user);

    /**
     * 根据激活码查询用户
     * @param code
     * @return
     */
    User findByCode(String code);

    /**
     * 修改用户状态
     * @param user
     */
    void updataStatus(User user);
}
