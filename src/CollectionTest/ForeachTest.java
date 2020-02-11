package CollectionTest;

import java.util.ArrayList;

public class ForeachTest {
    public static void main(String[] args) {

        System.out.println("------使用foreach遍历普通数组-------");
        int[] array = {1,2,3,4,5};
        for(int i: array){
            System.out.println(i);
        }

        System.out.println("------使用foreach遍历ArrayList--------");
        ArrayList<String> list = new ArrayList<>();
        list.add("Kylin");
        list.add("Ysl");
        list.add("Smq");
        for(String string: list) {
            System.out.println(string);
        }

    }
}
