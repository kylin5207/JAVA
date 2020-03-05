package FunctionalInterface.ConsumerTest;

import java.util.function.Consumer;

/*
    如果一个方法的参数和返回值全都是Consumer类型，那么就可以实现效果:
        消费数据的时候，首先做一个操作，然后再做一个操作，实现组合。而这个方法就是 Consumer 接口中的default方法 andThen()
    需要两个Consumer接口，再对数据进行消费：
        consumer1.andThen(consumer2).accept(x)：谁写前面，先消费
 */
public class ANDTHENTest {
    public static void main(String[] args) {
        String string = "Hello";

        //普通的lambda方式
        method(string, s -> System.out.println(s.toUpperCase()), s -> System.out.println(s.toLowerCase()) );

        //使用AndThen方法将两个Consumer接口连接到一起再消费
        method2(string, s -> System.out.println(s.toUpperCase()), s -> System.out.println(s.toLowerCase()) );

    }

    public static void method(String s, Consumer<String> con1, Consumer<String> con2) {
        con1.accept(s);
        con2.accept(s);
    }

    public static void method2(String s, Consumer<String> con1, Consumer<String> con2) {
        //写在前面的先消费
        con2.andThen(con1).accept(s);
    }
}
