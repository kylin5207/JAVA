package StreamTest.Demo;

import java.util.ArrayList;
import java.util.stream.Stream;

/*
    如果希望跳过前几个元素，可以使用skip()方法获取一个截取之后的新流:
        Stream<T> skip(long n);
            如果流的当前长度大于n，则跳过前n个;否则将会得到一个长度为0的空流。

 */
public class SkipTest {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(99);
        list.add(24);
        list.add(41);
        list.add(2);
        list.add(1);
        list.add(87);

        Stream<Integer> intstream = list.stream();

        Stream<Integer> skipstream = intstream.skip(3);

        skipstream.forEach(num-> System.out.println(num));
    }
}
