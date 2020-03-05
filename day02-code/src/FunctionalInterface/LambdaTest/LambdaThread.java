package FunctionalInterface.LambdaTest;
/*
    使用Lambda表达式作为方法参数，其实就是使用函数式 接口作为方法参数。

    例如 java.lang.Runnable接口就是一个函数式接口，假设有一个 startThread 方法使用该接口作为参数，那么就可以使用Lambda进行传参。
    这种情况其实和 Thread 类的构造方法参数为 Runnable 没有本质区别
 */

public class LambdaThread {
    public static void main(String[] args) {
        startThread(()-> System.out.println(Thread.currentThread().getName() + "启动"));

    }

    public static void startThread(Runnable runnable) {
        new Thread(runnable).start();
    }
}
