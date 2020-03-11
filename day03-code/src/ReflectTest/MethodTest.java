package ReflectTest;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
    使用Class对象获取Method对象：
    Method[] getMethods()
    Method getMethod(String name, 类<?>... parameterTypes)
    Method[] getDeclaredMethods()
    Method getDeclaredMethod(String name, 类<?>... parameterTypes)

    Method:⽅法对象执⾏方法:
        Object invoke(Object obj, Object... args)  ：参数：实例对象，方法参数
    获取方法名称:
         String getName:获取方法名

 */
public class MethodTest {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Class personClass = Person.class;
        Person person = new Person();

        //获取单个Method对象
        System.out.println("-------获取单个Method对象------------");
        Method method = personClass.getMethod("test");

        //执行方法(对象)
        System.out.println("Method对象对应的方法名：" + method.getName());
        method.invoke(person);

        //获取全部的Method对象
        System.out.println("-------获取全部的Method对象-----------");
        Method[] methods = personClass.getMethods();

        //其中包含Object类的方法，因为所有类都继承Object类
        for (Method method1 : methods) {
            System.out.println(method1.getName());
        }

    }
}
