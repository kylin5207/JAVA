import dao.UserDao;
import domain.User;
import mybatis.io.Resources;
import mybatis.sqlSession.SqlSession;
import mybatis.sqlSession.SqlSessionFactory;
import mybatis.sqlSession.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Mybatis入门案例
 * （使用main）
 */


public class UserDaoTest {
    public static void main(String[] args) throws IOException {
        //1. 读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");

        //2. 创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);

        //3. 使用工厂生产SqlSession对象
        SqlSession session = factory.openSession();

        //4. 使用SqlSession创建接口的代理对象
        UserDao userDao = session.getMapper(UserDao.class);

        //5. 使用代理对象执行方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
        }

        //6. 释放资源
        session.close();
        in.close();
    }
}
