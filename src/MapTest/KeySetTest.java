package MapTest;

//遍历map中的key值获取对应的value

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class KeySetTest {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        map.put("GDP", "国内生产总值");
        map.put("GNP", "国民生产总值");
        map.put("CPU", "中央存储单元");
        map.put("GPU", "图像处理单元");

        //使用foreach遍历
        //Map中的keySet()方法得到map集合中的所有键，保存在一个set集合中
        System.out.println("-----------使用增强的for循环----------");
        for(String key: map.keySet()) {
            //使用get(key)获取key对应的value值
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }

        //使用iterator迭代器方式遍历
        Iterator<String> iterator = map.keySet().iterator();
        System.out.println("-----------使用迭代器遍历----------");
        while(iterator.hasNext()) {
            String key = iterator.next();
            String value = map.get(key);
            System.out.println(key + " = " +value);
        }



    }
}
