package LoginCase.test;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;
import LoginCase.domain.User;

import java.lang.reflect.InvocationTargetException;

public class BeanUtilsTest {

    @Test
    public void test() throws InvocationTargetException, IllegalAccessException {
        User user = new User();

        BeanUtils.setProperty(user, "username", "zhangsan");
        System.out.println(user);
    }
}
