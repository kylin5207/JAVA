package service.impl;

import dao.IAccountDao;
import factory.BeanFactory;
import service.IAccountService;

public class AccountServiceImpl implements IAccountService {
    public void saveAccount() {
        IAccountDao accountDao = (IAccountDao) BeanFactory.getBean("accountDao");
//        System.out.println(accountDao);
        accountDao.saveAccount();
    }
}
