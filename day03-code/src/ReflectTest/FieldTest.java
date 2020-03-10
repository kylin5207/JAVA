package ReflectTest;

import java.lang.reflect.Field;

/*
    Class对象获取成员变量：
    Field[] getFields() :获取所有public修饰的成员变量
    Field getField(String name) 获取指定名称的public修饰的成员变量
    Field[] getDeclaredFields() 获取所有的成员变量，不考虑修饰
    Field getDeclaredField(String name)

        Field对象的方法：
            set(Object obj, Object value):设置值
            get(Object obj):获取值
            setAccessible(true):忽略访问权限修饰符的安全检查，暴力反射

 */
public class FieldTest {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        //1. 首先获取Person的Class对象
        Person person = new Person("Kylin",18, "1807");
        Class personClass = person.getClass();

        //2. 获取所有public修饰的成员变量
        Field[] fields = personClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }

        //3. Field getField(String name) 获取指定名称的public修饰的成员变量
        System.out.println("------------------------");
        Field classIDField = personClass.getField("classID");
        System.out.println("使用Field的get()方法获取person对象classID的值：" + classIDField.get(person));


        //4. Field[] getDeclaredFields() 获取所有的成员变量，不考虑修饰
        System.out.println("************************");
        Field[] declaredfields = personClass.getDeclaredFields();
        for (Field declaredfield : declaredfields) {
            System.out.println(declaredfield);
        }

        //5. Field getDeclaredField(String name)
        Field namefield = personClass.getDeclaredField("name");

        namefield.setAccessible(true); //暴力反射

        System.out.println(namefield.get(person));


    }
}
