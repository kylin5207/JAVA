package StreamTest.Introduction;

import java.util.ArrayList;
import java.util.List;

/*
    用Stream流的方式对集合进行操作
        1. JDK1.8之后出现的，更关注做什么
        2. 当需要对多个元素进行操作(特别是多步操作)的时候，考虑到性能及便利性，我们应该首先拼好一个“模型”步骤方案，然后再按照方案去执行它。
        3. “Stream流”其实是一个集合元素的函数模型，它并不是集合，也不是数据结构，其本身并不存储任何元素(或其地址值)
        4. 当使用一个流的时候，通常包括三个基本步骤:
            获取一个数据源(source)→ 数据转换 →执行操作获取想要的结果
            每次转换原有Stream对象不改变，返回一个新的Stream对象(可以有多次转换)，这就允许对其操作可以像链条一样排列，变成一个管道'
    所有的 Collection 集合都可以通过 stream 默认方法获取流
 */

public class StreamTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("kylin");
        list.add("Krush");
        list.add("Ysl");
        list.add("Sqi");
        list.add("Kim");

        list.stream()
                .filter(name->name.toLowerCase().startsWith("k"))
                .filter(name->name.length() == 3)
                .forEach(name-> System.out.println(name));

    }
}
