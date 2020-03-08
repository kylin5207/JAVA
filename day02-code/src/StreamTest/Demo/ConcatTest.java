package StreamTest.Demo;

import java.util.stream.Stream;

/*
    如果有两个流，希望合并成为一个流，那么可以使用 Stream 接口的静态方法 concat()
    static <T> Stream<T> concat(Stream<? extends T> a, Stream<? extends T> b)

 */
public class ConcatTest {
    public static void main(String[] args) {

        String[] array1 = {"a", "bb", "ccc", "d"};
        String[] array2 = {"Ann", "Bob", "Ken"};

        Stream<String> stream1 = Stream.of(array1);
        Stream<String> stream2 = Stream.of(array2);

        //将上面的两个流合成一个
        Stream<String> connection = Stream.concat(stream1, stream2);

        connection.forEach(s-> System.out.println(s));

    }
}
