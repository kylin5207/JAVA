package dao.impl;

import dao.UserDao;
import domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private SqlSessionFactory factory;

    public UserDaoImpl(SqlSessionFactory factory) {
        this.factory = factory;
    }

    public List<User> findAll() {
        //1. 根据factory获取sqlSession对象
        SqlSession session = factory.openSession();

        //2. 调用sqlSession中的方法，实现查询所有
        //参数是能获取到配置信息的key：nameSpace名称+方法名称
        List<User> users = session.selectList("dao.UserDao.findAll");

        //3. 释放资源
        session.close();
        return users;
    }

    public void saveUser(User user) {
        //1. 根据factory获取sqlSession对象
        SqlSession session = factory.openSession();

        //2. 调用sqlSession中的方法，实现查询所有
        //参数是能获取到配置信息的key：nameSpace名称+方法名称
        session.insert("dao.UserDao.saveUser", user);

        //3. 提交事务
        session.commit();

        //4. 释放资源
        session.close();
    }

    public void updateUser(User user) {
        //1. 根据factory获取sqlSession对象
        SqlSession session = factory.openSession();

        //2. 调用sqlSession中的方法，实现查询所有
        //参数是能获取到配置信息的key：nameSpace名称+方法名称
        session.update("dao.UserDao.updateUser", user);

        //3. 提交事务
        session.commit();

        //4. 释放资源
        session.close();

    }

    public void deleteUser(Integer id) {
        //1. 根据factory获取sqlSession对象
        SqlSession session = factory.openSession();

        //2. 调用sqlSession中的方法，实现删除
        //参数是能获取到配置信息的key：nameSpace名称+方法名称
        session.delete("dao.UserDao.deleteUser", id);

        //3. 提交事务
        session.commit();

        //4. 释放资源
        session.close();

    }

    public User findById(Integer userId) {
        //1. 根据factory获取sqlSession对象
        SqlSession session = factory.openSession();

        //2. 调用sqlSession中的方法，实现查询指定id的用户
        //参数是能获取到配置信息的key：nameSpace名称+方法名称
        User user = session.selectOne("dao.UserDao.findById", userId);

        //3. 释放资源
        session.close();
        return user;
    }

    public List<User> findByName(String username) {
        //1. 根据factory获取sqlSession对象
        SqlSession session = factory.openSession();

        //2. 调用sqlSession中的方法，实现查询所有
        //参数是能获取到配置信息的key：nameSpace名称+方法名称
        List<User> users = session.selectList("dao.UserDao.findByName", username);

        //3. 释放资源
        session.close();
        return users;
    }

    public int findTotal() {
        //1. 根据factory获取sqlSession对象
        SqlSession session = factory.openSession();

        //2. 调用sqlSession中的方法，实现记录条数
        //参数是能获取到配置信息的key：nameSpace名称+方法名称
        int count = session.selectOne("dao.UserDao.findTotal");

        //3. 释放资源
        session.close();
        return count;
    }
}
