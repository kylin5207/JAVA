package ThreadTest.ThreadSafety.SynchronizedMethod;

public class StaticTest {
    public static void main(String[] args) {

        RunnableStatic runnable = new RunnableStatic();

        Thread box1 = new Thread(runnable, "售票厅1");
        Thread box2 = new Thread(runnable, "售票厅2");
        Thread box3 = new Thread(runnable, "售票厅3");

        //开启多线程
        box1.start();
        box2.start();
        box3.start();
    }
}
