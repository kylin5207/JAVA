package MapTest;

//LinkedHashMap是有序的Map集合，可以保证存储顺序一致

import javax.print.DocFlavor;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapTest {
    public static void main(String[] args) {

        //首先，得到一个HashMap对象
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("Bob", 19);
        map1.put("Kylin", 18);
        map1.put("Anne", 21);
        map1.put("Sunny", 16);

        //
        System.out.println("---------遍历HashMap--------");
        System.out.println(map1);
        /*for(Map.Entry<String, Integer> entry : map1.entrySet()) {
            String name = entry.getKey();
            Integer age = entry.getValue();
            System.out.println(name + " = " + age);
        }*/

        //之后，得到一个LinkedHashMap对象
        Map<String, Integer> map2 = new LinkedHashMap<>();
        map2.put("Bob", 19);
        map2.put("Kylin", 18);
        map2.put("Anne", 21);
        map2.put("Sunny", 16);

        System.out.println("-------遍历LinkedHashMap----------");
        System.out.println(map2);
//        for(Map.Entry<String, Integer> entry : map2.entrySet()) {
//            String name = entry.getKey();
//            Integer age = entry.getValue();
//            System.out.println(name + " = " + age);
//        }



    }
}
