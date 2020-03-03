package CollectionTest;

import java.util.ArrayList;
import java.util.Collection;

//Collection是所有单列集合的顶层接口
//Collection里面定义了一些共性方法，底层类都可以使用
public class CollectionTest1 {
    public static void main(String[] args) {

        Collection<String> collection = new ArrayList<>();

//        add()向collection中添加元素
        collection.add("Kylin");
        collection.add("Ysl");
        collection.add("Smq");
        collection.add("PanPan"); //显然这个盼盼不合理

//        boolean remove(Object o)删除指定元素o
        boolean b1 = collection.remove("PanPan");
        System.out.println("删除成功？"+b1);

//        int size()返回集合中元素的个数
        System.out.println("元素个数为：" + collection.size());

//        boolean contains(Object o)判断集合中是否包含指定对象o
        boolean b2 = collection.contains("Kylin");
        System.out.println("集合中是否包含Kylin？" + b2);

//        boolean isEmpty()判断集合是否为空集合
        boolean b3 = collection.isEmpty();
        System.out.println("集合是否为空？" + b3);

//        Collection类重写了toString()方法
        System.out.println("集合中的元素："+collection.toString());

//        toArray()将集合转换为数据
        Object[] array = collection.toArray();
        System.out.println("--------遍历将集合转换为数组的值-------");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

//        void clear()清空集合中的元素
        collection.clear();
        System.out.println("清空集合中的元素后："+collection);
    }
}
