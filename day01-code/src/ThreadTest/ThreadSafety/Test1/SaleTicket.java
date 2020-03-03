package ThreadTest.ThreadSafety.Test1;

/*
    模拟三个售票处，同时出售这100张票
    线程安全问题都是由全局变量及静态变量引起的。若每个线程中对全局变量、静态变量只有读操作，而无写操作，一般来说，这个全局变量是线程安全的;
    若有多个线程同时执行写操作，一般都需要考虑线程同步，否则的话就可能影响线程安全。
 */

public class SaleTicket {
    public static void main(String[] args) {
        RunnableImpl runnable = new RunnableImpl();
        Thread box1 = new Thread(runnable, "售票厅1");
        Thread box2 = new Thread(runnable, "售票厅2");
        Thread box3 = new Thread(runnable, "售票厅3");

        //开启多线程
        box1.start();
        box2.start();
        box3.start();

        //几个窗口的票数不同步，线程不安全

    }
}
