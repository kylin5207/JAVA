package service.impl;

import dao.IAccountDao;
import dao.impl.AccountDaoImpl;
import service.IAccountService;

import java.util.Date;

/**
 * 构造函数依赖注入
 */

public class AccountServiceImpl implements IAccountService {
    //对于经常变化的数据，并不适用于注入方式
    private String name;
    private Integer age;
    private Date birthday;

    public AccountServiceImpl(String name, Integer age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public void saveAccount() {
        System.out.println("Service中的saveAccount方法执行了。。。" + name + "," + age + "," + birthday);
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "AccountServiceImpl{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }
}
