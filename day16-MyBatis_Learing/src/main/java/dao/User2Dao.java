package dao;

import domain.QueryVo;
import domain.QueryVo2;
import domain.User;
import domain.User2;

import java.util.List;

/**
 * 用户——数据访问层接口
 */
public interface User2Dao {

    /**
     * 查找所有用户
     * @return
     */
    List<User2> findAll();

    /**
     * 保存用户
     * @param user
     */
    void saveUser2(User2 user);

    /**
     * 更新用户
     * @param user
     */
    void updateUser2(User2 user);

    /**
     * 根据id删除用户
     * @param id
     */
    void deleteUser2(Integer id);

    /**
     * 根据id查询用户信息
     * @param userId
     * @return
     */
    User2 findById(Integer userId);

    /**
     * 根据username进行模糊查询
     * @param username
     * @return
     */
    List<User2> findByName(String username);

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
    List<User2> findUserByVo(QueryVo2 vo);
}
