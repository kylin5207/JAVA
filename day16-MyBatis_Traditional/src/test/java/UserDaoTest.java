import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.User;
import org.apache.ibatis.io.Resources;
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
    private UserDao userDao;

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

        //3. 使用工厂对象创建Dao对象
        userDao = new UserDaoImpl(factory);

    }

    /**
     * 释放资源（测试方法执行之后运行）
     */
    @After
    public void destroy(){
        try{

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
        user.setUsername("Ysl");
        user.setAddress("洛阳");
        user.setSex("男");
        user.setBirthday(new Date());

        //5. 使用代理对象执行方法
        System.out.println("插入前的user");
        System.out.println(user);
        userDao.saveUser(user);
        System.out.println("插入后的user");
        System.out.println(user);

    }

    @Test
    public void testUpdate() throws IOException {
        User user = new User();
        user.setId(51);
        user.setUsername("Kylin");
        user.setAddress("郑州");
        user.setSex("男");
        user.setBirthday(new Date());

        //5. 使用代理对象执行方法
        userDao.updateUser(user);

    }

    @Test
    public void testDelete() throws IOException {
        int id = 52;
        //5. 使用代理对象执行方法
        userDao.deleteUser(id);
    }

    @Test
    public void testFindById() throws IOException {
        int id = 48;
        //5. 使用代理对象执行方法
        User user = userDao.findById(id);
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
        List<User> users = userDao.findByName(name);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindTotal() throws IOException {
        int count = userDao.findTotal();
        System.out.println("总记录数：" + count);
    }

}
