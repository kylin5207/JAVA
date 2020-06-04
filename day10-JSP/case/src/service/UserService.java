package service;

import domain.User;

import java.util.List;

/**
 * 用户管理的业务接口
 */
public interface UserService {

    /**
     * 查询所有用户信息
     * @return
     */
    public List<User> findAll();

    //用户登陆
    public User login(User user);

    //添加User
    public void addUser(User user);

    public void deleteUser(String id);

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    public User findUserById(String id);
}
