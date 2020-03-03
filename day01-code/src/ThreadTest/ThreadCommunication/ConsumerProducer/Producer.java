package ThreadTest.ThreadCommunication.ConsumerProducer;
/*
    生产者类
   注意：生产者和消费者之间是互斥关系，需要使用同步技术
        锁对象要保证唯一，我们可以使用产品对象作为锁对象
 */

public class Producer extends Thread{
    private Product baozi;

    public Producer() {
    }

    public Producer(Product baozi) {
        this.baozi = baozi;
    }

    //生产者的线程任务：生产产品
    public void run() {
        int count = 0;

        synchronized (baozi) {
            //生产者一直生产产品
            while(true) {

                if (baozi.flag == true) {
                    try {
                        baozi.wait();
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                    }
                }

                if (count % 2 == 0) {
                    baozi.setWrapper("冰皮");
                    baozi.setFilling("五仁");
                } else {
                    baozi.setWrapper("酥皮");
                    baozi.setFilling("莲蓉");
                }

                count++;

                System.out.println("生产者：我正在做好吃的产品🥮！-->" + baozi.getWrapper() + baozi.getFilling());

                //生产一个产品需要3秒
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                baozi.flag = true;

                baozi.notify();
                System.out.println("生产者已经生产好了" + baozi.getWrapper() + baozi.getFilling() + "🥮，消费者可以来拿了");
            }
        }
    }

}
