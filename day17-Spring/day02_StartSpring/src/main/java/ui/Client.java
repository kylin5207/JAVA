package ui;

import dao.IAccountDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.IAccountService;
import service.impl.AccountServiceImpl;

public class Client {
    /**
     * 获取spring的IOC核心容器，并根据id获取对象
     *
     * ApplicationContext的三个常用实现类：
     *      ClassPathXmlApplicationContext(常用方式)  加载类路径下的配置文件，要求配置文件必须在类路径下，不在的话，加载失败
     *      FileSystemXmlApplicationContext 加载磁盘任意路径下的配置文件(必须有访问权限才可以)
     *      AnnotationConfigApplicationContext(常用方式) 用于读取注解创建容器
     * @param args
     */
    public static void main(String[] args) {
        //1. 获取核心容器对象
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");

        //2. 根据id获取bean对象
        IAccountService service = (IAccountService) ac.getBean("accountService");
        IAccountDao dao = ac.getBean("accountDao", IAccountDao.class);

        //3. 调用方法
        System.out.println(service);
        System.out.println(dao);

        //4. 手动关闭容器
//        ac.close();
    }
}
