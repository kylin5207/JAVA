package service;

import domain.Account;

import java.util.List;

/**
 * 账户的业务层接口
 *
 */
public interface IAccountService {
    /**
     * 查询所有
     * @return
     */
    List<Account> findAllAccount();


    /**
     * 根据Id查找
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * 保存操作
     * @param account
     */
    void saveAccount(Account account);

    /**
     * 更新操作
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 删除操作
     * @param accountId
     */
    void deleteAccount(Integer accountId);
}
