package StreamTest.Demo;

import java.util.ArrayList;
import java.util.stream.Stream;

/*
    流提供count()来统计的元素个数:
        long count():终结方法，返回值是一个long类型的整数，不能继续调用Stream流中的其他方法

 */
public class CountTest {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(99);
        list.add(24);
        list.add(41);
        list.add(2);
        list.add(1);
        list.add(87);

        Stream<Integer> intstream = list.stream();
        System.out.println("元素个数：" + intstream.count());

    }
}
