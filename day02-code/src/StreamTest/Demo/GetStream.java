package StreamTest.Demo;
/*
    Stream接口：java.util.stream.Stream<T>
    获取流的方式：
        1. 所有的Collection集合都可以通过 stream 默认方法获取流;
        2. Stream 接口的静态方法 of 可以获取数组对应的流。
             of方法的参数其实是一个可变参数，所以支持数组
 */

import java.util.*;
import java.util.stream.Stream;

public class GetStream {
    public static void main(String[] args) {
        //使用集合的stream方法得到Stream流对象
        List<String> list = new ArrayList<>();
        Stream liststream = list.stream();

        Set<String> set = new HashSet<>();
        Stream setstream = set.stream();

        //将map集合转换为Stream流(间接转换)
        //java.util.Map 接口不是 Collection 的子接口，且其K-V数据结构不符合流元素的单一特征，所以获取对应的流，需要分key、value或entry等情况
        Map<String, String> map = new HashMap<>();
        Set<String> keyset = map.keySet();
        Stream keystream = keyset.stream();
        Collection<String> values = map.values();
        Stream valuestream = values.stream();
        Set<Map.Entry<String, String>> keyvalueset =  map.entrySet();
        Stream<Map.Entry<String, String>> keyvaluestream = keyvalueset.stream();

        //使用Stream的静态方法of()获取流对象
        String[] array = {"kylin", "smq", "ysl"};
        Stream<String> stream = Stream.of(array);

    }
}
