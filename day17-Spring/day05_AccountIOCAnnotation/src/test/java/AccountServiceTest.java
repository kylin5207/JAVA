import domain.Account;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.IAccountService;

import java.util.List;

/**
 * 使用JUnit进行单元测试
 *  每个测试方法都重新获取了一次spring的核心容器，造成了不必要的重复
 *
 *  emmm还是存在缺点的，这种方式虽然能解决问题，但是扔需要我们自己写代码来获取容器。
 */
public class AccountServiceTest {
    //1. 获取容器
    ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

    //2. 得到业务层对象
    IAccountService service = ac.getBean("accountService", IAccountService.class);

    @Test
    public void testFindAll(){
        //3. 执行方法
        List<Account> accountList = service.findAllAccount();

        for (Account account : accountList) {
            System.out.println(account);
        }
    }

    @Test
    public void testFindOne(){
        //3. 执行方法
        Account account = service.findAccountById(1);
        System.out.println(account);
    }

    @Test
    public void testSave(){
        //3. 执行方法
        Account account = new Account();
        account.setName("林梦");
        account.setMoney(2223.5f);
        service.saveAccount(account);
        testFindAll();
    }

    @Test
    public void testUpdate(){
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
