package dao;

import domain.Account;

import java.util.List;

public interface AccountDao {

    /**
     * 查询所有账单
     * @return
     */
    List<Account> findAll();


}
