package ThreadTest.ThreadSafety.Test1;

/*
        电影院要卖票，模拟电影院的卖票过程
        假设要播放的电影是 “爱情公寓”，本次电影的座位共100个(本场电影只能卖100张票)。
        我们来模拟电影院的售票窗口，实现多个窗口同时卖 “爱情公寓”这场电影票(多个窗口一起卖这100张票)
        需要窗口，采用线程对象来模拟;
        需要票，Runnable接口子类来模拟
 */


public class RunnableImpl implements Runnable {
    //定义多个线程共享的票源
    private int ticket_num = 100;
    @Override
    public void run() {
        //卖票
        while (true) {
            if (ticket_num > 0) {
                System.out.println(Thread.currentThread().getName() + "剩余" + ticket_num + "张票");
                ticket_num--;
            }
            else {
                System.out.println("票卖完了！");
                break;
            }
        }
    }
}
