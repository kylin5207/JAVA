package ThreadTest;

/*
    public static void sleep(long millis) :使当前正在执行的线程以指定的毫秒数暂停(暂时停止执行)。
 */

public class ThreadSleepTest {
    public static void main(String[] args) throws InterruptedException {
        //模拟秒表
        for (int i = 1; i < 60; i++) {
            System.out.println(i);

            //使用Thread类的sleep方法，让程序睡眠1秒=1000毫秒
            Thread.sleep(1000);
        }
    }
}
