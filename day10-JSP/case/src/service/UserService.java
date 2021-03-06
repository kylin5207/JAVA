package service;

import domain.PageBean;
import domain.User;

import java.util.List;
import java.util.Map;

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

    /**
     * 修改用户信息
     * @param user
     */
    public void updateUser(User user);

    /**
     * 批量删除用户
     * @param ids
     */
    void delSelectedUser(String[] ids);

    /**
     * 分页条件查询
     * @param currentPage
     * @param rows
     * @param condition
     * @return
     */
    PageBean<User> findUserByPage(int currentPage, int rows, Map<String, String[]> condition);
}
