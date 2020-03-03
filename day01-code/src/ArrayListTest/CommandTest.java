package ArrayListTest;


import java.util.ArrayList;

public class CommandTest {
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();

//        1. 添加元素add element
//        注意：add方法有一个boolean类型的返回值，表示添加元素是否成功。
        list.add("Anne");
        list.add("Bob");
        list.add("Cancy");
        list.add("David");

//        2. 获取元素get（int index），返回index位置上的元素
        System.out.println(list.get(2));

//        3. 从集合中删除指定位置的元素remove（int index），并返回该元素
        System.out.println("删除元素前的集合："+list);
        System.out.println("删除的元素："+list.remove(2));
        System.out.println("删除后的集合："+list);

//        4. 获取集合的大小size（）
        System.out.println("当前集合的大小："+list.size());

//        5. 集合的遍历 listfori
        for (int i = 0; i < list.size(); i++) {

            System.out.print(list.get(i)+", ");

        }

        System.out.println();
    }
}
