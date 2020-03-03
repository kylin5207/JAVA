package ThreadTest.MainThreadTest;


/*
    主线程：执行主（main）方法的线程

    单线程程序：java程序中只有一个线程
    JVM从main方法开始执行 ，从上到下依次执行
*/

public class MainThreadTest {
    public static void main(String[] args) {
        Person person1 = new Person("Kylin");
        person1.run();

        Person person2 = new Person("伊二狗");
        person2.run();
    }
}
