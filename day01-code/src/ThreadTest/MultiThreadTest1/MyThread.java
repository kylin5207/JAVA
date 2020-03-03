package ThreadTest.MultiThreadTest1;

/*
    继承Thread类，并重写run()方法
 */

public class MyThread extends Thread{
    public MyThread() {
    }

    public void run(){

        for (int i = 0; i < 10; i++) {
            System.out.println("run : " + i);
        }
    }


}
