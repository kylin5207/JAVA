package dao;

import domain.Account;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface AccountDao {

    /**
     * 获取所有用户，并且获取账户所属的所有用户信息
     * @return
     */
    @Select("select * from account")
    @Results(id="AccountMap", value={
            @Result(id=true, column = "id", property = "id"),
            @Result(column = "uid", property = "uid"),
            @Result(column = "money", property = "money"),
            @Result(property = "user", column = "uid", one=@One(select="dao.UserDao.findByUid", fetchType= FetchType.EAGER))
    })
    List<Account> findAll();
}
