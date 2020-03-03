package ThreadTest.ThreadCommunication.ConsumerProducer;

/*
    消费者类
 */

public class Custom extends Thread {
    private Product baozi;

    public Custom() {
    }

    public Custom(Product baozi) {
        this.baozi = baozi;
    }

    public void run() {
        while (true) {

            synchronized (baozi) {

                if (baozi.flag == false) {
                    try {
                        baozi.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                //唤醒之后，执行消费
                System.out.println("消费者：我正在吃" + baozi.getWrapper() + baozi.getFilling() + "的🥮");
                baozi.flag = false;

                //唤醒生产者继续生产
                baozi.notify();

                System.out.println("消费者吃掉了产品，生产者继续生产～");
                System.out.println("------------------------------");
            }
        }
    }
}
