package dao.impl;

import dao.IAccountDao;
import domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * 账户持久层实现类
 */

@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {
    @Autowired
    private QueryRunner runner;

    public List<Account> findAllAccount() {
        String sql = "select * from account";
        try {
            return runner.query(sql, new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Account findAccountById(Integer accountId) {
        String sql = "select * from account where id = ?";
        try {
            return runner.query(sql, new BeanHandler<Account>(Account.class), accountId);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void saveAccount(Account account) {
        String sql = "insert into account(name, money) values(?,?)";
        try {
            runner.update(sql, account.getName(), account.getMoney());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void updateAccount(Account account) {
        String sql = "update account set name = ?, money = ? where id = ?";
        try {
            runner.update(sql, account.getName(), account.getMoney(), account.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteAccount(Integer accountId) {
        String sql = "delete from account where id = ?";
        try {
            runner.update(sql, accountId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
