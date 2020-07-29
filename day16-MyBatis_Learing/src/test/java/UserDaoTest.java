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
import java.util.Date;
import java.util.List;

/**
 * Mybatis入门案例
 * （使用main）
 */


public class UserDaoTest {
    private InputStream in;
    private SqlSession sqlSession;
    private UserDao userDao;
//    public static void main(String[] args) throws IOException {
//        //1. 读取配置文件
//        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
//
//        //2. 创建SqlSessionFactory工厂
//        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
//        SqlSessionFactory factory = builder.build(in);
//
//        //3. 使用工厂生产SqlSession对象
//        SqlSession session = factory.openSession();
//
//        //4. 使用SqlSession创建接口的代理对象
//        UserDao userDao = session.getMapper(UserDao.class);
//
//        //5. 使用代理对象执行方法
//        List<User> users = userDao.findAll();
//        for (User user : users) {
//            System.out.println(user);
//        }
//
//        //6. 释放资源
//        session.close();
//        in.close();
//    }

    /**
     * 初始化(测试方法，执行前执行)
     * @throws IOException
     */
    @Before
    public void init() throws IOException {
        //1. 读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");

        //2. 创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);

        //3. 使用工厂生产SqlSession对象
        sqlSession = factory.openSession();

        //4. 使用SqlSession创建接口的代理对象
        userDao = sqlSession.getMapper(UserDao.class);
    }

    /**
     * 释放资源（测试方法执行之后运行）
     */
    @After
    public void destroy(){
        try{
            //提交事务
            sqlSession.commit();
            if(sqlSession != null){
                sqlSession.close();
            }
            if(in != null){
                in.close();
            }

        }
        catch (Exception e){
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
    public void testSave() throws IOException {
        User user = new User();
        user.setUsername("Kylin");
        user.setAddress("洛阳");
        user.setSex("男");
        user.setBirthday(new Date());

        //5. 使用代理对象执行方法
        userDao.saveUser(user);

    }
}