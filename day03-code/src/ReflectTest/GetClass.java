package ReflectTest;

/*
    获取Class对象的⽅式:
    1. Class.forName("全类名"):将字节码⽂件加载进内存，返回Class对象
        多⽤于配置文件，将类名定义在配置文件中。读取文件，加载类
    2. 类名.class:通过类名的属性class获取
        多⽤用于参数的传递
    3. 对象.getClass():getClass()⽅法在Object类中定义着。
        多⽤于对象的获取字节码的方式

    结论：
        同一个字节码文件(.class)在一次程序运行过程中，只会被加载一次，不论通过那种方式获取。

 */
public class GetClass {
    public static void main(String[] args) throws ClassNotFoundException {
        //1. Class.forName("类名")：得到Class
        Class personClass = Class.forName("ReflectTest.Person");
        System.out.println(personClass);

        //2. 类名.class:通过类名的属性class获取
        Class personClass2 = Person.class;
        System.out.println(personClass2);

        //3. 对象.getClass()
        Person person = new Person();
        Class personClass3 = person.getClass();
        System.out.println(personClass3);

        //用==比较三个对象是否相同
        System.out.println("三个Class对象是否相同：" + (personClass == personClass2 && personClass == personClass3));
    }
}
