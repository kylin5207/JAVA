package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.PageBean;
import domain.User;
import service.UserService;

import java.util.List;

/**
 * 用户管理的业务接口的实现类
 */
public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();

    @Override
    public List<User> findAll() {
        //调用UserDao完成查询
        return dao.findAll();
    }

    public User login(User user){
        return dao.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public void addUser(User user) {
        dao.add(user);
    }

    @Override
    public void deleteUser(String id) {
        dao.delete(Integer.parseInt(id));
    }

    @Override
    public User findUserById(String id) {
        return dao.findById(Integer.parseInt(id));
    }

    @Override
    public void updateUser(User user) {
        dao.update(user);
    }

    @Override
    public void delSelectedUser(String[] ids) {
        //遍历数组
        for (String id : ids) {
            //调用dao删除
            dao.delete(Integer.parseInt(id));
        }
    }

    @Override
    public PageBean<User> findUserByPage(int currentPage, int rows) {
        // 1. 创建一个空的PageBean对象
        PageBean<User> pb = new PageBean<User>();

        // 2. 设置参数
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);

        // 3. 调用dao查询totalCount
        int totalCount = dao.findTotalCount();
        pb.setTotalCount(totalCount);

        // 4. 调用dao查询list集合
        // 计算开始的索引
        int start = (currentPage-1) * rows;
        List<User> list = dao.findByPage(start, rows);
        pb.setList(list);

        // 5. 设置totalPage
        int totalPage = (totalCount % rows) == 0 ? totalCount / rows : (totalCount / rows) + 1;
        pb.setTotalPage(totalPage);
        return pb;
    }
}
