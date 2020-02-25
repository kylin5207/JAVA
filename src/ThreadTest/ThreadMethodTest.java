package ThreadTest;

/*
    获取线程名称：
        1. 使用Thread类中的方法getName()
        2. 使用Thread.currentThread()获取当前正在执行的线程，使用getName（）获取正在执行的线程的名称

    设置线程的名称：
        1. 使用Thread类中的setName(String name)改变线程名称，使之与参数name相同
        2. 使用带参数的构造方法，参数传递name，调用父类的带参数的构造方法

*/
class Thread1 extends Thread {
    public Thread1() {
    }

    public Thread1(String name) {
        super(name);
    }

    public void run() {
//        String name = this.getName();
//        System.out.println(name);
        System.out.println("当前正在运行的线程：" + Thread.currentThread().getName());
    }
}
public class ThreadMethodTest {
    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        thread1.start(); //输出Thread-0

        Thread1 thread2 = new Thread1();
        thread2.start(); //输出Thread-1

        Thread1 thread3 = new Thread1("自定义线程");
        thread3.start();

        Thread1 thread4 = new Thread1();
        thread4.setName("自定义线程2");
        thread4.start();

    }
}
