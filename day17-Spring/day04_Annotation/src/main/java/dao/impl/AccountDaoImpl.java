package dao.impl;

import dao.IAccountDao;
import org.springframework.stereotype.Repository;

@Repository("accountDao")
public class AccountDaoImpl implements IAccountDao {
    public void saveAccount() {
        System.out.println("保存用户");
    }
}
