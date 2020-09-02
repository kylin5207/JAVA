package service.impl;

import dao.IAccountDao;
import dao.impl.AccountDaoImpl;
import service.IAccountService;

public class AccountServiceImpl implements IAccountService {
    private IAccountDao dao = new AccountDaoImpl();

    public AccountServiceImpl(){
        System.out.println("对象创建了");
    }

    public void saveAccount() {
        dao.saveAccount();
    }

    public void init(){
        System.out.println("service中的对象初始化了");
    }

    public void destroy(){
        System.out.println("service中的对象销毁了");
    }
}
