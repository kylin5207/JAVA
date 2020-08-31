package ui;

import factory.BeanFactory;
import service.IAccountService;

public class Client {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            IAccountService as = (IAccountService) BeanFactory.getBean("accountService");
            System.out.println(as);
            as.saveAccount();
        }
    }
}
