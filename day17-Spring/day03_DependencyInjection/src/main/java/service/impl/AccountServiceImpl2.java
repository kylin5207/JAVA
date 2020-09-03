package service.impl;

import service.IAccountService;

import java.util.Date;

/**
 * 使用set方法进行依赖注入
 */
public class AccountServiceImpl2 implements IAccountService {
    //对于经常变化的数据，并不适用于注入方式
    private String name;
    private Integer age;
    private Date birthday;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void saveAccount() {
        System.out.println("Service中的saveAccount方法执行了。。。" + name + "," + age + "," + birthday);
    }
}
