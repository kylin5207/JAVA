package ThreadTest.ThreadSafety.SynchronizedMethod;
/*
    解决线程同步的第二种方案：使用同步方法
    格式：
        public sychronized void method(){
            相关的同步代码
        }
    同步方法中的锁：
        对于非static方法,同步锁就是this。
        对于static方法,我们使用当前方法所在类的字节码对象(类名.class)。

 */
public class RunnableImpl implements Runnable{
    //定义多个线程共享的票源
    private int ticket_num = 100;

    //定义同步方法
    public synchronized void sale() {
        if (ticket_num > 0) {
            System.out.println(Thread.currentThread().getName() + "剩余" + ticket_num + "张票");
            ticket_num--;
        }
    }


    @Override
    public void run() {
        System.out.println("this : " + this);

        //卖票
        while (ticket_num > 0) {
            sale();
        }
    }

}
