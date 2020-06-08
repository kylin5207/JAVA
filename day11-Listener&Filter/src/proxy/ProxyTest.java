package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理模式：
 * 实现步骤:
 * 1. 代理对象和真实对象实现相同的接口
 * 2. 代理对象 = Proxy.newProxyInstance(三个参数)
 * 3. 使用代理对象调用方法
 * 4. 增强方法
 *
 * 增强⽅式:
 * 1. 增强参数列表
 * 2. 增强返回值类型
 * 3. 增强⽅法体执⾏逻辑
 */
public class ProxyTest {
    public static void main(String[] args) {
        //1. 创建真实对象
        Lenovo lenovo = new Lenovo();

        //2. 动态代理增强lenovo对象
        //三个参数：第一个是类加载器：真实对象.getClass().getClassLoader()
        //         第二个参数是接口数组：真实对象..getClass().getInterfaces()
        //         第三个是处理器：new InvocationHandler(){}匿名类
        SaleComputer proxy_lenovo = (SaleComputer) Proxy.newProxyInstance(lenovo.getClass().getClassLoader(), lenovo.getClass().getInterfaces(), new InvocationHandler() {
            /*
                代理逻辑编辑的方法，代理对象调用的所有方法都会触发该方法执行
                参数：
                    1. proxy：代理对象
                    2. method对象：代理对象调用的方法被封装为Method对象
                    3. objects: 代理对象调用方法时，传递的实际参数
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] objects) throws Throwable {
//                System.out.println("该方法被执行");
//                System.out.println(method.getName());
//                System.out.println(objects[0]);
                //使用真实对象调用该方法
                //1. 增强参数
                if(method.getName().equals("sale")){
                    double money = (double)objects[0];
                    money = money * 0.85;
                    System.out.println("专车接");
                    String obj = (String)method.invoke(lenovo, money);
                    System.out.println("免费送货");
                    //2. 增强返回值
                    return obj + "_无线鼠标";
                }
                else {
                    Object obj = method.invoke(lenovo, objects);
                    return obj;
                }

            }
        });

        //2. 调用方法
        String computer = proxy_lenovo.sale(2000);
        System.out.println(computer);
//        proxy_lenovo.show();
    }
}
