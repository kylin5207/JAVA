package LambdaTest;

/*
借助JDK1.8 推出的lambda，实现线程类的方式可以通过更简单的Lambda表达式达到等效:
 */

public class ThreadTest {
    public static void main(String[] args) {

        new Thread(() -> {
            System.out.println("多线程任务执行!");
        }
        ).start(); // 启动线程

    }
}
