package ThreadTest.ThreadCommunication.ConsumerProducer;

/*
        包子铺线程生产包子，吃货线程消费包子。
        当包子没有时(包子状态为false)，吃货线程等待，
        包子铺线程生产包子 (即包子状态为true)，并通知吃货线程(解除吃货的等待状态),因为已经有包子了，那么包子铺线程进入等待状态。
        接下来，吃货线程能否进一步执行则取决于锁的获取情况。
        如果吃货获取到锁，那么就执行吃包子动作，包子吃完(包子状态为false)，并通知包子铺线程(解除包子铺的等待状态),吃货线程进入等待。
        包子铺线程能否进一步执行则取决于锁的获取情况。
 */


public class Test {
    public static void main(String[] args) {

        Product baozi = new Product();

        Producer producer = new Producer(baozi);

        Custom consumer = new Custom(baozi);

        producer.start();

        consumer.start();

    }
}
