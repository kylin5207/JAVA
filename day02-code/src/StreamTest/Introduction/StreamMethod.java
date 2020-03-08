package StreamTest.Introduction;

import java.util.ArrayList;
import java.util.stream.Stream;

/*
    集合处理对方式(Stream流方法)

    现在有两个 ArrayList 集合存储队伍当中的多个成员姓名，要求使用传统的for循环(或增强for循环)依次进行以下若干操作步骤:
    1. 第一个队伍只要名字为3个字的成员姓名;存储到一个新集合中。
    2. 第一个队伍筛选之后只要前3个人;存储到一个新集合中。
    3. 第二个队伍只要姓张的成员姓名;存储到一个新集合中。
    4. 第二个队伍筛选之后不要前2个人。
    5. 将两个队伍合并为一个队伍。
    6. 根据姓名创建 Person 对象;存储到一个新集合中。
    7. 打印整个队伍的Person对象信息。
 */
public class StreamMethod {
    public static void main(String[] args) {
        //第一支队伍
        ArrayList<String> one = new ArrayList<>();
        one.add("迪丽热巴");
        one.add("宋远桥");
        one.add("苏星河");
        one.add("石破天");
        one.add("石中玉");
        one.add("老子");
        one.add("庄子");
        one.add("洪七公");

        //第二支队伍
        ArrayList<String> two = new ArrayList<>();
        two.add("古力娜扎");
        two.add("张无忌");
        two.add("赵丽颖");
        two.add("张三丰");
        two.add("尼古拉斯赵四");
        two.add("张天爱");
        two.add("张二狗");

//        1. 第一个队伍只要名字为3个字的成员姓名,第一个队伍筛选之后只要前3个人;存储到一个新集合中。
        Stream<String> stream1 = one.stream().filter(s->s.length()==3).limit(3);

//        2. 第二个队伍只要姓张的成员姓名,第二个队伍筛选之后不要前2个人;存储到一个新集合中。
        Stream<String> stream2 = two.stream().filter(s->s.startsWith("张")).skip(2);

//        3. 将两个队伍合并为一个队伍。
        Stream<String> stream3 = Stream.concat(stream1,stream2);

//        4. 根据姓名创建 Person 对象;存储到一个新集合中。
        Stream<Person> personStream = stream3.map(s->new Person(s));

//        5. 打印整个队伍的Person对象信息。
        personStream.forEach(person-> System.out.println(person));
    }
}
