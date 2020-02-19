package MapTest;

//Map双列集合常用方法测试

import java.util.HashMap;
import java.util.Map;

public class MapMethodTest {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        /*
        向map中添加key-value键值对
        public V put(K key, V value)方法:
        如果key和Map中的key不冲突，则返回V的值为null；
        如果key和Map中的key冲突，则key的值替换为新的value，并返回替换前的value值。
        */
        map.put("GDP", "国内生产总值");
        map.put("GNP", "国民生产总值");
        map.put("CPU", "中央存储单元");
        map.put("GPU", "图像处理单元");

        System.out.println("当前map集合："+map);

        /*
        删除指定key所对应的键值对元素
        public V remove(Object key)方法：
        如果key存在，则返回key所对应的值；
        如果key不存在，则返回空值null
        */
        System.out.println("删除元素：" + map.remove("GPU"));
        System.out.println("删除元素：" + map.remove("GUI"));//键为GUI的键值对不存在，所以返回null

        /*
        通过key获取对应的value元素
        public V get(Object key)方法：
        如果key存在，返回key对应的值；
        如果key不存在，返回null
        */
        System.out.println("GDP对应的值：" + map.get("GDP"));
        System.out.println("SHE对应的值：" + map.get("SHE"));//不存在指定键的value，返回null

        /*
        查看map中是否包含指定的key
        boolean containsKey(Object key):
        判断map集合中是否包含指定的key
        如果包含，则返回true；
        如果不包含，则返回false
        */
        System.out.println("map集合中是否包含键\"GDP\" ? " + map.containsKey("GDP"));
        System.out.println("map集合中是否包含键\"FLY\" ? " + map.containsKey("FLY"));

    }

}
