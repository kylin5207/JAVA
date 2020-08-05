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
     * 根据id查询用户信息
     * @param userId
     * @return
     */
    User findById(Integer userId);

    /**
     * 根据username进行模糊查询
     * @param username
     * @return
     */
    List<User> findByName(String username);

    /**
     * 查询总用户数
     * @return
     */
    int findTotal();

    /**
     * 根据传入的参数条件进行用户查询
     * @param user : 该user可能只有一个属性，也可能都有，也可能一个也没有
     * @return
     */
    List<User> findUserByCondition(User user);


    /**
     * 查找所有用户而且显示用户的所有账单信息
     * @return
     */
    List<User> findAllUserAccounts();

    /**
     * 查询用户的所有角色信息
     * @return
     */
    List<User> findAllUserRoles();

    void updateUser(User user);
}
