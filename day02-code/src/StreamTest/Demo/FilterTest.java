package StreamTest.Demo;

import java.util.stream.Stream;

/*
    过滤：可以通过 filter 方法将一个流转换成另一个子集流
    Stream<T> filter(Predicate<? super T> predicate);
        接收一个 Predicate 函数式接口参数(可以是一个Lambda或方法引用)作为筛选条件。
            Predicate有一个抽象方法：boolean test(T t);

 */
public class FilterTest {
    public static void main(String[] args) {
        Stream<String> namestream = Stream.of("Kylin", "Anne", "Brush", "Jeni", "John", "King");


        Stream<String> filterstream = namestream.filter(s->s.startsWith("K"));

        filterstream.forEach( name->System.out.println(name));

    }
}
