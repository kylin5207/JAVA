package dao;

import domain.Account;

import java.util.List;

public interface AccountDao {

    /**
     * 查询所有账单
     * @return
     */
    List<Account> findAll();

    /**
     * 查询所有账单，并且带有用户名和地址信息
     * 这种方式实际用的不多
     * @return
     */
    List<Account> findAllAccount();
}
