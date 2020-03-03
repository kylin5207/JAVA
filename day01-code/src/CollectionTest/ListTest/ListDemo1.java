package CollectionTest.ListTest;

//注意：避免索引越界异常

import java.util.ArrayList;
import java.util.List;

public class ListDemo1 {
    public static void main(String[] args) {

//        首先，创建一个list列表
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");

        //输出当前列表元素
        System.out.println("列表元素："+list);

//        使用void add(int index, E e)在指定index索引处添加一个新的元素e
        list.add(3,"Kylin");
        System.out.println("在索引3处添加元素后的列表："+list);

//        使用E remove(int index)移除指定索引的元素并返回该元素
        System.out.println("移除元素"+list.remove(3));
        System.out.println("列表元素"+list);

//        使用E set(int index, E e)将指定索引处的元素用e替换，返回替换前的元素
        System.out.println("将元素"+list.set(2, "Replace")+"替换");
        System.out.println("列表元素"+list);

        //使用foreach遍历list
        for (String str: list) {
            System.out.println(str);
        }
    }
}
