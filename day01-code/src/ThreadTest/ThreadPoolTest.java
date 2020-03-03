package ThreadTest;
/*
    线程池测试

    JDK1.5之后提供：
    java.util.concurrent.Executors:线程池的工厂类

    public static ExecutorService newFixedThreadPool(int nThread)创建一个可重用固定线程数
        参数：nThread是最大线程数量
        返回值：ExecutorService接口

    使用步骤：
        1. 使用线程池工厂类提供的newFixedThreadPool生产一个指定线程数量的线程池
        2. 创建一个类，实现Runnable接口，重写run(),设置线程任务
        3. 调用ExecutorService中的submit，传递线程任务（实现类），开启线程，执行run（）方法
        4. 调用shutdown（）销毁线程池（一般不建议执行）
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class RunnableImpl implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "创建了一个新的线程");
    }
}

public class ThreadPoolTest {
    public static void main(String[] args) {

        ExecutorService pool = Executors.newFixedThreadPool(2);

        //线程池会一直开启，当使用完了线程，会自动把线程归还给线程池，之后线程可以继续执行

        pool.submit(new RunnableImpl());
        pool.submit(new RunnableImpl());
        pool.submit(new RunnableImpl());


//        pool.shutdown(); //销毁线程池，一般不做
    }
}
