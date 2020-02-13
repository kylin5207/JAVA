package CollectionTest;
//Collections工具类测试

import java.util.ArrayList;
import java.util.Collections;

public class CollectionsTest {
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();

//        list.add("a");
//        list.add("b");
//        list.add("c");
//        list.add("d");

//        使用addAll静态方法添加元素
        Collections.addAll(list,"a","b", "c", "d", "e");
        System.out.println(list);

        Collections.shuffle(list);
        System.out.println("shuffle后的list：" + list);

        Collections.sort(list); //使用默认的sort排序
        System.out.println("sort后的list：" + list);

    }
}
