import dao.User2Dao;
import dao.UserDao;
import domain.QueryVo;
import domain.QueryVo2;
import domain.User;
import domain.User2;
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


public class User2DaoTest {
    private InputStream in;
    private SqlSession sqlSession;
    private User2Dao userDao;
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
        userDao = sqlSession.getMapper(User2Dao.class);
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
        List<User2> users = userDao.findAll();
        for (User2 user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testSave() throws IOException {
        User2 user = new User2();
        user.setUserName("Kim");
        user.setUserAddress("河南");
        user.setUserSex("女");
        user.setUserBirthday(new Date());

        //5. 使用代理对象执行方法
        System.out.println("插入前的user2");
        System.out.println(user);
        userDao.saveUser2(user);
        System.out.println("插入后的user");
        System.out.println(user);

    }

    @Test
    public void testUpdate() throws IOException {
        User2 user = new User2();
        user.setUserId(43);
        user.setUserName("王小二");
        user.setUserAddress("北京");
        user.setUserSex("男");
        user.setUserBirthday(new Date());

        //5. 使用代理对象执行方法
        userDao.updateUser2(user);
    }

    @Test
    public void testDelete() throws IOException {
        int id = 50;
        //5. 使用代理对象执行方法
        userDao.deleteUser2(id);
    }

    @Test
    public void testFindById() throws IOException {
        int id = 48;
        //5. 使用代理对象执行方法
        User2 user = userDao.findById(id);
        System.out.println(user);
    }

//    基于自动填充%的模糊查询
//    @Test
//    public void testFindByName1() throws IOException {
//        String username = "王";
//
//        //5. 使用代理对象执行方法
//        List<User> users = userDao.findByName(username);
//        for (User user : users) {
//            System.out.println(user);
//        }
//    }

    /**
     * 手动添加%的模糊查询
     * @throws IOException
     */
    @Test
    public void testFindByName2() throws IOException {
        String username = "王";
        String name = "%"+username+"%";
        //5. 使用代理对象执行方法
        List<User2> users = userDao.findByName(name);
        for (User2 user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindTotal() throws IOException {

        int count = userDao.findTotal();
        System.out.println("总记录数：" + count);
    }

    /**
     * 测试使用QueryVo作为查询条件进行模糊查询
     * @throws IOException
     */
    @Test
    public void testFindByName3() throws IOException {
        QueryVo2 vo = new QueryVo2();
        User2 user = new User2();
        user.setUserName("%王%");
        vo.setUser(user);
        //5. 使用代理对象执行方法
        List<User2> users = userDao.findUserByVo(vo);
        for (User2 u : users) {
            System.out.println(u);
        }
    }

}
