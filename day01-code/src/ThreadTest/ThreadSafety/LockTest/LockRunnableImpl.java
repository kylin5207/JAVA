package ThreadTest.ThreadSafety.LockTest;

/*
    实现同步的第三种方法——Lock锁
        1. Lock锁和同步代码块/同步方法具有的功能之外更强大,更体现面向对象
        2. Lock是一个接口
        3. public void lock():获取锁
           public void unlock():释放锁

    使用方法：
        1. 在成员对象的位置创建一个ReentrantLock对象
        2. 在可能出现安全问题的代码前调用lock接口中的lock（）方法获取锁
        3. 在可能出现安全问题的代码后调用unlock()释放锁
*/

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockRunnableImpl implements Runnable{
    //定义多个线程共享的票源
    private int ticket_num = 100;
    Lock mylock = new ReentrantLock();


    @Override
    public void run() {
        //卖票
        while (ticket_num > 0) {


            mylock.lock();

            try{
                if (ticket_num > 0) {
                    System.out.println(Thread.currentThread().getName() + "剩余" + ticket_num + "张票");
                    ticket_num--;
                } else {
                    System.out.println("票卖完了！");
                    break;
                }
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
            finally {
                mylock.unlock();
            }
        }
    }
}
