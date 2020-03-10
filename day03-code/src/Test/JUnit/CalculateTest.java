package Test.JUnit;

import Test.NormalMethod.Calculate;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/*
    Calculate的测试类
    1. 建议：
        测试类名:被测试的类名Test
        方法名：test测试的方法名
                返回值：void
                参数：空参
        给测试方法上面加上@Test
    2. 判断结果：
    *    红色:失败
    *    绿色:成功

    3. 一般我们会使用断⾔操作来处理结果
        Assert.assertEquals(期望的结果,运算的结果);

 */
public class CalculateTest {

    @Before
    public void init() {
        /*
        初始化方法，用于资源申请，所以测试方法在执行之前都会先执行该方法
         */
        System.out.println("------申请资源------");
    }

    @Test
    public void testAdd() {
        Calculate calculate = new Calculate();

        int result = calculate.add(1,2);

        //使用断言来处理结果
        Assert.assertEquals(3, result);

    }

    @After
    public void close() {
        /*
            释放资源， 所以测试方法执行完之后，都会自动执行该方法
         */
        System.out.println("----释放资源-----");
    }
}
