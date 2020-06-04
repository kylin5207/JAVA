package dao;

import domain.User;

import java.util.List;

/**
 * 用户操作的Dao
 */
public interface UserDao {
    public List<User> findAll();
    public User findUserByUsernameAndPassword(String username, String password);

    public void add(User user);

    public void delete(int id);

    public User findById(int id);

    public void update(User user);

    /**
     * 查询总记录数
     * @return
     */
    int findTotalCount();

    /**
     * 分页查询每页记录
     * @param start
     * @param rows
     * @return
     */
    List<User> findByPage(int start, int rows);
}
