package StreamTest.Demo;

import java.util.stream.Stream;

/*
    void forEach(Consumer<? super T> action);逐一处理
    该方法接收一个 Consumer 接口函数，会将每一个流元素交给该函数进行处理。

    注意：
        该方法是一个终结方法，遍历之后就不能继续调用Stream流中的其他方法
 */
public class ForEachTest {
    public static void main(String[] args) {

        Stream<String> stream = Stream.of("张三", "李四", "王五", "赵四");
        stream.forEach((name)-> System.out.println(name));

    }
}
