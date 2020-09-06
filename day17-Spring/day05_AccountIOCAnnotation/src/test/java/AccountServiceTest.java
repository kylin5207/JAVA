import config.JdbcConfig;
import config.SpringConfiguration;
import domain.Account;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import service.IAccountService;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 使用JUnit进行单元测试
 *  每个测试方法都重新获取了一次spring的核心容器，造成了不必要的重复
 *  emmm还是存在缺点的，这种方式虽然能解决问题，但是扔需要我们自己写代码来获取容器。
 *
 *  Spring整合junit的配置：
 *      1. 导入Spring整合junit的jar（坐标）
 *      2、使用Junit提供的一个注解把原有的main方法替换了，替换成spring提供的  @Runwith
 *      3、告知spring的运行器，spring和ioc创建是基于xml还是注解的，并且说明位置
 *      @ContextConfiguration
 *          locations：指定xml文件的位置，加上classpath关键字，表示在类路径下
 *          classes：指定注解类所在的位置
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest {

    @Autowired
    private IAccountService service;

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
