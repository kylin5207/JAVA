package ThreadTest.MultiThreadTest1;
/*
    创建线程的第二种方式：实现runnable接口，并实现run（）。之后将该类的实例作为Thread的target对象，传递给Thread的构造方法

    public Thread(Runnable target) :分配一个带有指定目标新的线程对象。
    public Thread(Runnable target,String name) :分配一个带有指定目标新的线程对象并指定名字。

    1. 创建runnable的实现类
    2. 重写run（）方法
    3. 创建一个runnable接口的实现类对象
    4. 创建一个Thread对象，构造方法中传递runnable接口的实现类对象
    5. 使用Thread对象的start（）方法，开启线程
 */

class RunnableTest implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + "--->" + i);
        }
    }
}
public class MultiThreadTest2 {
    public static void main(String[] args) {
        Runnable runnable = new RunnableTest();
        Thread thread = new Thread(runnable);
        thread.start();


        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + "--->" + i);
        }

    }

}
