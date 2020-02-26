package ThreadTest.ThreadSafety.LockTest;

public class SaleTickets {
    public static void main(String[] args) {
        LockRunnableImpl runnable = new LockRunnableImpl();

        Thread box1 = new Thread(runnable, "售票厅1");
        Thread box2 = new Thread(runnable, "售票厅2");
        Thread box3 = new Thread(runnable, "售票厅3");

        //开启多线程
        box1.start();
        box2.start();
        box3.start();
    }
}
