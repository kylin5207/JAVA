package dao;

import domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * 用户——数据访问层接口
 * 一共有四个注解：
 * Select，Update，Delete，Insert
 */
@CacheNamespace(blocking = true)
public interface UserDao {

    /**
     * 查找所有用户
     * @return
     */
    @Select("select * from user")
    List<User> findAll();

    @Insert("insert into user(username, address, sex, birthday) values(#{username}, #{address}, #{sex}, #{birthday})")
    void saveUser(User user);

    @Update("update user set username=#{username}, sex=#{sex}, address=#{address}, birthday=#{birthday} where id=#{id}")
    void updateUser(User user);

    @Delete("delete from user where id = #{id}")
    void deleteUser(Integer id);

    @Select("select * from user where id = #{id}")
    User findByUid(Integer id);

    /**
     * 根据用户名称模糊查询
     * @param name
     * @return
     */
    @Select("select * from user where username like #{name}")
//    @Select("select * from user where username like '%${value}%'")
    List<User> findUserByName(String name);

    /**
     * 查询总用户数量
     * @return
     */
    @Select("select count(*) from user")
    int findTotal();

    @Select("select * from user")
    @Results(id="UserAccountMap", value={
            @Result(id=true, column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "address", property = "address"),
            @Result(column = "sex", property = "sex"),
            @Result(column = "birthday", property = "birthday"),
            @Result(property = "accounts", column = "id", many = @Many(select = "dao.AccountDao.findAccountByUid", fetchType= FetchType.LAZY))
    })
    List<User> findUserAccount();

}
