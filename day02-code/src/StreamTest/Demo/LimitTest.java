package StreamTest.Demo;

import java.util.stream.Stream;

/*
    limit()方法可以对流进行截取，只取用前n个:
        Stream<T> limit(long maxSize);
            1。参数是一limit方法是一个延迟方法，只是对流中的元素进行截取，返回的是一个新的流，可继续调用Stream流中的其他方法个long型，如果集合当前长度大于参数则进行截取;否则不进行操作
            2。limit方法是一个延迟方法，只是对流中的元素进行截取，返回的是一个新的流，可继续调用Stream流中的其他方法
 */
public class LimitTest {
    public static void main(String[] args) {
        String[] array = {"a", "bb", "ccc", "d"};
        Stream<String> strstream = Stream.of(array);

        Stream<String> limitstream = strstream.limit(2);

        limitstream.forEach(s-> System.out.println(s));

    }
}
