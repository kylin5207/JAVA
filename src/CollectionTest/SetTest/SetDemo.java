package CollectionTest.SetTest;

/*
    Set接口特点：没有重复元素，没有索引，不能使用普通的for循环，但是可以用迭代器和foreach
    HashSet特点：底层是一个哈希表结构，查询速度非常快
*/

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetDemo {
    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
        set.add("aa");
        set.add("bb");
        set.add("cc");
        set.add("dd");

        //考虑到set不含索引，不能用普通的for循环
        //使用迭代器遍历
        System.out.println("使用迭代器遍历set集合");

        Iterator it = set.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }

        //使用foreach
        System.out.println("使用增强的for循环遍历Set集合");

        for(String str: set) {
            System.out.println(str);
        }
    }
}
