package ReflectTest.Demo;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.Set;

/*
    案例:
        需求:写⼀个"框架"，不能改变该类的任何代码的前提下，可以帮我们创建任意类的对象，并且执⾏其中任意⽅法
    实现:
        1. 配置文件
        2. 反射
    步骤:
        1. 将需要创建的对象的全类名和需要执⾏的⽅法定义在配置⽂件中
        2. 在程序中加载读取配置文件
        3. 使⽤用反射技术来加载类⽂件进内存
        4. 创建对象
        5. 执⾏⽅法
 */
public class ReflectDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //可以执行或创建任意类的对象，可以或者执行任意方法
        //1. 加载配置文件
        //使用类加载器来获取配置文件对应的字节输入流
        Properties properties = new Properties();
        ClassLoader classLoader = ReflectDemo.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("properties");
        properties.load(is);

        //2. 获取配置文件中获取的数据
        Set<String> property = properties.stringPropertyNames();
        for (String s : property) {
            String value = properties.getProperty(s);
            System.out.println(s + " = " + value);
        }
        String className = properties.getProperty("className");
        String methodName = properties.getProperty("methodName");

        //3. 使⽤用反射技术来加载类⽂件进内存
        Class cls = Class.forName(className);

        //4. 创建对象
        Object obj = cls.newInstance();
        Method method = cls.getMethod(methodName);

        //5. 执⾏⽅法
        method.invoke(obj);


//        不能改变该类的任何代码
//        Person p = new Person();
//        p.test();


    }
}
