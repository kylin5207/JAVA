import domain.Account;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.IAccountService;

import java.util.List;

/**
 * 使用JUnit进行单元测试
 */
public class AccountServiceTest {
    @Test
    public void testFindAll(){
        //1. 获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        //2. 得到业务层对象
        IAccountService service = ac.getBean("accountService", IAccountService.class);

        //3. 执行方法
        List<Account> accountList = service.findAllAccount();

        for (Account account : accountList) {
            System.out.println(account);
        }
    }

    @Test
    public void testFindOne(){
        //1. 获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        //2. 得到业务层对象
        IAccountService service = ac.getBean("accountService", IAccountService.class);

        //3. 执行方法
        Account account = service.findAccountById(1);
        System.out.println(account);
    }

    @Test
    public void testSave(){
        //1. 获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        //2. 得到业务层对象
        IAccountService service = ac.getBean("accountService", IAccountService.class);

        //3. 执行方法
        Account account = new Account();
        account.setName("帅琦");
        account.setMoney(1234.5f);
        service.saveAccount(account);
        testFindAll();
    }

    @Test
    public void testUpdate(){
        //1. 获取容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        //2. 得到业务层对象
        IAccountService service = ac.getBean("accountService", IAccountService.class);

        //3. 执行方法(先查询原来的数据)
        Account account = service.findAccountById(1);
        System.out.println("-----before update------");
        System.out.println(account);

        //4. 执行更新
        account.setMoney(600f);
        service.updateAccount(account);

        //5. 再次查询
        Account account2 = service.findAccountById(1);
        System.out.println("-----after update------");
        System.out.println(account2);
    }

    public void testDelete(){

    }
}
