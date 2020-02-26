package ThreadTest.ThreadSafety.SynchroizedTest;

/*
    解决线程安全问题——使用同步代码块
     synchronized(同步锁){
        需要同步操作的代码
     }

     注意：
        1. 锁对象可以是任何类型
        2. 多个线程使用的锁对象是同一个
        3. 锁对象作用：
            把同步代码块锁住，只让一个线程在同步代码块中执行
 */
public class RunnableImpl implements Runnable {
    //定义多个线程共享的票源
    private int ticket_num = 100;

    //创建一个锁对象，注意创建在run方法的外面
    Object object = new Object();

    @Override
    public void run() {
        //卖票
        while (true) {
            synchronized (object) {
                if (ticket_num > 0) {
                    System.out.println(Thread.currentThread().getName() + "剩余" + ticket_num + "张票");
                    ticket_num--;
                } else {
                    System.out.println("票卖完了！");
                    break;
                }
            }
        }
    }
}
