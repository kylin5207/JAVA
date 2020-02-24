package ThreadTest.MultiThreadTest1;

/*
        创建多线程程序的第一种方式：创建Thread类的子类
        之后调用其start()方法开启线程，执行run（）:
            1。结果是两个线程并发执行（main线程和新创建的线程）
            2。此外，该线程执行调度依次
            3。抢占式调度，优先级高的优先执行
 */
public class MultiThreadTest {
    public static void main(String[] args) {

        MyThread thread1 = new MyThread();
        thread1.start();

        for (int i = 0; i < 10; i++) {
            System.out.println("main Thread ：" + i);
        }

    }

}
