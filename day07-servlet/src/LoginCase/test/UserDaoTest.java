package LoginCase.test;

import org.junit.Test;
import LoginCase.dao.UserDao;
import LoginCase.domain.User;

public class UserDaoTest {

    @Test
    public void testLogin(){
        UserDao userDao = new UserDao();
        User loginUser = new User(3, "kylin", "smq");
        System.out.println(userDao.login(loginUser));
    }
}
