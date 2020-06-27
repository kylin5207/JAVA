package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.UserDao;
import cn.itcast.travel.dao.impl.UserDaoImpl;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.util.MailUtils;
import cn.itcast.travel.util.UuidUtil;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    /**
     * 注册用户
     * @param user
     * @return
     */
    @Override
    public boolean regist(User user) {

        //1. 根据用户名查找对象
        User u = userDao.findByUsername(user.getUsername());

        if(u != null){
            //用户名存在，注册失败
            return false;
        }

        //用户名不存在，注册成功
        //2.1 设置激活码，唯一字符串
        user.setCode(UuidUtil.getUuid());

        //2.2 设置激活状态
        user.setStatus("N");
        userDao.save(user);

        //邮件发送，发送激活邮件
        String content = "<a href='http://localhost/activeUserServlet?code="+user.getCode()+"'>点击激活【来自帅琦的问候】</a>";
        MailUtils.sendMail(user.getEmail(), content, "激活邮件");

        return true;
    }
}
