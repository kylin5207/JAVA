package GenericTest;

//含有泛型接口的实现类的测试类

public class GenericInterfaceImplTest {
    public static void main(String[] args) {

        //实现类中指定泛型
        System.out.println("---------实现接口时就指定泛型类型------");
        GenericInterfaceImpl gi1 = new GenericInterfaceImpl();
        gi1.method("字符串");

        System.out.println("-------创建对象时，再指定泛型类型--------");
        //创建对象时再指定泛型
        GenericInterfaceImpl2<Integer> gi2 = new GenericInterfaceImpl2<>();
        gi2.method(2);

        GenericInterfaceImpl2<String> gi3 = new GenericInterfaceImpl2<>();
        gi3.method("string");



    }
}
