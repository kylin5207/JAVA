package GenericTest;

import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.Iterator;

/*

泛型通配符？：代表任意的数据对象
注意：只能用来接收数据，不能创建对象使用，只能作为方法的参数使用

*/
public class CommonUseGeneric {
    public static void main(String[] args) {

        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(0);
        list1.add(2);
        System.out.println("----遍历Integer集合----");
        printArrayList(list1);

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("aa");
        list2.add("bb");
        System.out.println("----遍历String集合----");
        printArrayList(list2);

    /*    泛型的上下限
                上限：? extends E 代表使用的泛型只能是E类型的子类或者本身
                下限：？super E 代表使用的泛型只能时E类型的父类/本身
    */
        

    }

//    创建一个方法，遍历各种ArrayList集合
    public static void printArrayList(ArrayList<?> list) {
        Iterator<?> it = list.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
