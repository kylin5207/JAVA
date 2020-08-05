import dao.UserDao;
import domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserDaoTest {

    private InputStream in;
    private SqlSession sqlSession;
    private UserDao userDao;
    private SqlSessionFactory factory;

    /**
     * 初始化(测试方法，执行前执行)
     *
     * @throws IOException
     */
    @Before
    public void init() throws IOException {
        //1. 读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");

        //2. 创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        factory = builder.build(in);

        //3. 使用工厂生产SqlSession对象
        //factory.openSession(true);实现事务自动提交
        sqlSession = factory.openSession();

        //4. 使用SqlSession创建接口的代理对象
        userDao = sqlSession.getMapper(UserDao.class);
    }

    /**
     * 释放资源（测试方法执行之后运行）
     */
    @After
    public void destroy() {
        try {
            //提交事务
            sqlSession.commit();
            if (sqlSession != null) {
                sqlSession.close();
            }
            if (in != null) {
                in.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindAll() throws IOException {

        //5. 使用代理对象执行方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindUserAccounts() throws IOException {
        //5. 使用代理对象执行方法
        List<User> users = userDao.findAllUserAccounts();
        for (User user : users) {
            System.out.println(user);
            System.out.println(user.getAccounts());
        }
    }

    /**
     * 一级缓存
     * (只要sqlSession没有close或者flush，则里面的缓存一直存在；
     * 否则，消失)
     */
    @Test
    public void testFirstLevelCache(){
        User user1 = userDao.findById(41);
        System.out.println(user1);

        //或者用sqlSession.clearCache();清空缓存
        sqlSession.close();

        //再次开启sqlSession
        sqlSession = factory.openSession();
        userDao = sqlSession.getMapper(UserDao.class);

        User user2 = userDao.findById(41);
        System.out.println(user2);

        //如果SqlSession没有被close或者flush，则一直存在
        System.out.println(user1 == user2);

    }

    /**
     * 测试缓存的同步
     */
    @Test
    public void testSynchronizeCache(){
        //1. 查询用户
        User user1 = userDao.findById(41);
        System.out.println(user1);

        //2. 更新用户
        user1.setUsername("老王头");
        user1.setAddress("河南");
        userDao.updateUser(user1);

        //3. 再次查询id为41的用户
        User user2 = userDao.findById(41);
        System.out.println(user2);
    }
}
