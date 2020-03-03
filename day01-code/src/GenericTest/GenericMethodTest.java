package GenericTest;
//测试含有泛型的方法
public class GenericMethodTest {
    public static void main(String[] args) {

        GenericMethod gm = new GenericMethod();

//        含有泛型的方法，调用方法时才确定泛型的数据类型
//        传递何种类型的数据，泛型就是什么类型
        gm.show(123);

        gm.show("strings");

        gm.show(0.99);

        method(132);
        method("static generic method");
    }

//    定义一个静态泛型方法
    public static <E> void method(E e) {
        System.out.println(e);
    }
}
