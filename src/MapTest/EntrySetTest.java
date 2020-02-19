package MapTest;

//使用键值对Entry遍历map集合

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class EntrySetTest {
    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();

        map.put("GDP", "国内生产总值");
        map.put("GNP", "国民生产总值");
        map.put("CPU", "中央存储单元");
        map.put("GPU", "图像处理单元");

        //1. 使用map.entrySet()得到map集合中的entry对象放在一个Set中
        Set<Map.Entry<String, String>> set = map.entrySet();

        //2. 遍历Set集合
        System.out.println("-------使用迭代器遍历-------");
        Iterator<Map.Entry<String, String>> iterator = set.iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            //3. 使用Entry对象的getKey()获取键，getValue()获取值
            String key = entry.getKey();
            String value = entry.getValue();

            System.out.println(key + " = " + value);
        }

        System.out.println("------使用增强的for循环遍历-------");
        for(Map.Entry<String, String> entry : set) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

    }
}
