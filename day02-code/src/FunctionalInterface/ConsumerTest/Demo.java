package FunctionalInterface.ConsumerTest;

import java.util.function.Consumer;

/*
    java.util.function.Consumer<T> 接口则正好与Supplier接口相反，它不是生产一个数据，而是消费一个数据，其数据类型由泛型决定.

    Consumer 接口中包含抽象方法 void accept(T t) ，意为消费一个指定泛型的数据。

 */
public class Demo {

    public static void main(String[] args) {
        consume("Kylin", (String name) -> {
            System.out.println("Hello, " + name);
        });
    }

    public static void consume(String name, Consumer<String> consumer) {
    /*
        定义一个方法，方法的参数传递字符串的姓名，方法的参数传递Consumer接口，泛型使用String，消费传递进来的姓名
     */
        consumer.accept(name);
    }
}
