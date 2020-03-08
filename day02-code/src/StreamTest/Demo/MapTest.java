package StreamTest.Demo;

import java.util.stream.Stream;

/*
    如果需要将流中的元素映射到另一个流中，可以使用 map 方法
    <R> Stream<R> map(Function<? super T, ? extends R> mapper);

 */
public class MapTest {
    public static void main(String[] args) {
        Stream<Integer> numstream = Stream.of(1,2,3,4);

        //使用map方法映射为Integer类型的整数
        Stream<String> strstream = numstream.map(num -> String.valueOf(num));

        strstream.forEach(s -> System.out.println(s));
    }
}
