package dao;

import domain.QueryVo;
import domain.QueryVo3;
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

    /**
     * 更新用户
     * @param user
     */
    void updateUser(User user);

    /**
     * 根据id删除用户
     * @param id
     */
    void deleteUser(Integer id);

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
     * 根据QueryVo传递的条件查询User
     * @param vo
     * @return
     */
    List<User> findUserByVo(QueryVo vo);

    /**
     * 根据传入的参数条件进行用户查询
     * @param user : 该user可能只有一个属性，也可能都有，也可能一个也没有
     * @return
     */
    List<User> findUserByCondition(User user);

    /**
     * 根据id列表查找用户
     * @param vo
     * @return
     */
    List<User> findUserByIds(QueryVo3 vo);
}
