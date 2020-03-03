package CollectionTest.ComparableTest;
/*
Comparable：需要实现类实现Comparable接口中的compareTo方法
Comparator: 利用匿名内部类传递给sort方法
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ComparatorTest {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(4);
        list.add(2);

        System.out.println("列表元素：" + list);

        Collections.sort(list, new Comparator<Integer>() {
            @Override//重写比较规则
            public int compare(Integer integer, Integer t1) {
                return integer - t1; //升序排序
            }
        });

        System.out.println("生序排序后："+list);
    }
}
