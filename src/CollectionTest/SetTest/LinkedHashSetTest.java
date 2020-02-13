package CollectionTest.SetTest;

import java.util.HashSet;
import java.util.LinkedHashSet;

//双链表结构，一条链表用于记录元素的存储顺序，保证元素有序
public class LinkedHashSetTest {
    public static void main(String[] args) {
        //hashset是无序的
        HashSet<String> set = new HashSet<>();

        set.add("aaa");
        set.add("bbb");
        set.add("ccc");
        set.add("ddd");

        System.out.println("普通的hashSet输出：");
        System.out.println(set);

        //创建保证元素有序的LinkedHashSet对象
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();

        linkedHashSet.add("aaa");
        linkedHashSet.add("bbb");
        linkedHashSet.add("ccc");
        linkedHashSet.add("ddd");

        System.out.println("有序的LinkedHashSet输出：");
        System.out.println(linkedHashSet);


    }
}
