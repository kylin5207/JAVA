package CollectionTest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IteratorTest {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();

//        add()向collection中添加元素
        collection.add("Kylin");
        collection.add("Ysl");
        collection.add("Smq");

//        使用iterator()获取collection对应的迭代器
        Iterator<String> it = collection.iterator();

        System.out.println("--------使用while循环---------");
//        使用迭代器遍历集合元素
        while (it.hasNext())
        {
            System.out.println(it.next());
        }

        System.out.println("---------使用for循环-------");
//        使用for循环(了解即可)
        for (Iterator<String> it2 = collection.iterator(); it2.hasNext(); ) {
            String e = it2.next();
            System.out.println(e);
        }
    }
}
