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

public class SecondLevelCacheTest {

    private InputStream in;
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
    }

    /**
     * 释放资源（测试方法执行之后运行）
     */
    @After
    public void destroy() throws IOException {
        in.close();
    }

    /**
     * 二级缓存
     * (只要sqlSession没有close或者flush，则里面的缓存一直存在；
     * 否则，消失)
     */
    @Test
    public void testSecondLevelCache(){
        SqlSession sqlSession1 = factory.openSession();
        UserDao userDao = sqlSession1.getMapper(UserDao.class);
        User user1 = userDao.findById(41);
        System.out.println(user1);

        sqlSession1.close(); //一级缓存消失

        SqlSession sqlSession2 = factory.openSession();
        UserDao userDao2 = sqlSession2.getMapper(UserDao.class);
        User user2 = userDao2.findById(41);
        System.out.println(user2);

        //或者用sqlSession.clearCache();清空缓存
        sqlSession2.close();

        //二级缓存中存放的是数据，而不是对象
        System.out.println(user1 == user2);

    }


}
