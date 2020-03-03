package ThreadTest;

import java.util.Objects;

/*
    等待唤醒案例：线程间的合作
        消费者线程：告知生产者要的物品的数量，调用wait()方法，放弃CPU执行，进入到WAITTING状态（无限等待）
        生产者线程：5s生产一个，做好后，调用notify()方法，唤醒消费者
    注意：
        生产者和消费者线程必须使用同步代码块包裹起来，保证等待和唤醒只能有一个在执行
        同步使用的锁对象必须保证唯一
        只有锁对象才能调用wait()和notify()

 */
public class ThreadCollaberation {
    public static void main(String[] args) {
        //创建锁对象，保证唯一
        Object obj = new Object();

        //创建一个消费者线程
        Thread custom = new Thread(){

            public void run() {

                while (true) {
                    synchronized (obj) {

                        System.out.println("消费者：我要一个布丁蛋糕🍮");

                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            System.out.println(e.getMessage());
                        }
                        System.out.println("消费者拿了一个产品");
                        System.out.println("----------------------");
                    }
                }
            }
        };

        custom.start();

        //创建一个生产者线程
        Thread producer = new Thread() {
            public void run() {

                while(true) {
                    try {
                        Thread.sleep(5000); // 5s做一个产品
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }

                    synchronized (obj) {
                        System.out.println("生产者5s后生产好产品，告知消费者");
                        obj.notify();
                    }
                }
            }
        };

        producer.start();
    }
}
