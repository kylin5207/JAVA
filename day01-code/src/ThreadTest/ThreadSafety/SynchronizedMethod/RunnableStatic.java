package ThreadTest.ThreadSafety.SynchronizedMethod;
/*
    使用静态方法实现同步问题
 */

import javax.print.attribute.standard.RequestingUserName;

public class RunnableStatic implements Runnable {
    private static int ticket_num = 100;

    //定义同步方法
    //静态同步方法的锁对象不是this，而是本类的class字节码对象
    public static void sale() {
        synchronized (RunnableStatic.class) {
            if (ticket_num > 0) {
                System.out.println(Thread.currentThread().getName() + "剩余" + ticket_num + "张票");
                ticket_num--;
            }
        }
    }


    @Override
    public void run() {
        //卖票
        while (ticket_num > 0) {
            sale();
        }
    }
}
