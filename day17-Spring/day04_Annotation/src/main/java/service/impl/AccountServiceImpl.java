package service.impl;

import org.springframework.stereotype.Component;
import service.IAccountService;

import java.util.Date;

/**
 * 账户业务层注解
 *
 * 曾经XML配置：
 * <bean id="accountService" class="service.impl.AccountServiceImpl"></bean>
 *
 * 用于创建对象的注解
 *      作用与xml配置文件中编写<bean></bean>标签实现的功能是一样的
 *      @Component
 *          作用：用于把当前类对象存入spring容器中
 *          属性：
 *              value：用于指定bean的id。当我们不写时，它的默认值是当前类名，且首字母改小写。
 *
 *          @Controller：一般用在表现层
 *          @Service：一般用在业务层
 *          @Repository：一般用在持久层
 *          以上三个注解他们的作用和属性与Component是一模一样
 *
 * 用于注入数据的注解
 *      作用与xml配置文件中的<bean></bean>标签中写一个<property></property>标签的作用是一样的
 *
 * 用于改变作用范围的注解
 *      作用与在bean标签中使用scope属性实现的功能是一样的

 *
 * 和生命周期相关
 *      作用与<bean></bean>标签使用的init—method和destroy-method是一样的
 *
 */

@Component("accountService")
public class AccountServiceImpl implements IAccountService {

    public void saveAccount() {
        System.out.println("Service中的saveAccount方法执行");
    }

}
