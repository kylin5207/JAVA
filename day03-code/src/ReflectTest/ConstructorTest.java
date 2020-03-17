package ReflectTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/*
    Class对象获取Constructor构造方法对象：
        Constructor<?>[] getConstructors()
        Constructor<T> getConstructor(类<?>... parameterTypes)
        Constructor<T> getDeclaredConstructor(类<?>... parameterT
        Constructor<?>[] getDeclaredConstructors()

    Constructor:构造方法创建对象:
        T newInstance(Object... initargs)
        如果使用空参数构造方法创建对象，操作可以简化:Class对象的newInstance⽅法
 */
public class ConstructorTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class personClass = Person.class;

        //获取Constructor对象
        Constructor constructor = personClass.getConstructor(String.class, int.class, String.class);
        System.out.println(constructor);

        //使用Constructor对象创建新对象
        Object person  = constructor.newInstance("kylin", 18, "201807");
        System.out.println(person);

        //获取Constructor为空参数的对象
        System.out.println("----------使用空参数的构造方法------------");
        Constructor constructor2 = personClass.getConstructor();
        System.out.println(constructor2);

        //使用Constructor对象创建新对象
        Object person2  = constructor2.newInstance();
        System.out.println(person2);

        //创建空参数的类对象可以直接使用Class对象创建
        Object person3 = personClass.newInstance();
        System.out.println(person3);
    }
}
