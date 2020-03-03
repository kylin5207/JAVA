package ThreadTest.MultiThreadTest1;
/*
    使用匿名类方式实现线程的创建
 */
public class AnonymityClassTest {
    public static void main(String[] args) {

        //使用匿名内部类的方式实现Runnable接口
        Runnable r = new Runnable() {
            public void run(){
                for (int i = 0; i < 20; i++) {
                    System.out.println(Thread.currentThread().getName() + "--->" + i);
                }
            }
        };

        Thread thread = new Thread(r);
        thread.start();

        //使用匿名内部类的方式实现Thread类的子类
        Thread thread2 = new Thread(){
            public void run() {
                for (int i = 0; i < 20; i++) {

                    System.out.println(Thread.currentThread().getName() + "--->" + i);
                }
            }
        };
        thread2.start();

        //main主线程中的一个循环
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + "--->" + i);
        }
    }
}
