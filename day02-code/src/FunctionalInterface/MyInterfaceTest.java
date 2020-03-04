package FunctionalInterface;

/*
    函数式接口的使用：一般可以作为方法的参数和返回值类型
 */

public class MyInterfaceTest {
    public static void main(String[] args) {
        show(new MyInterface() {
            @Override
            public void method() {
                System.out.println("--使用匿名内部类的重写接口中的抽象方法--");
            }
        });

        show(() -> System.out.println("--使用lambda表达式重写接口中的抽象方法--"));

    }
    public static void show(MyInterface myInterface){
        myInterface.method();
    }
}
