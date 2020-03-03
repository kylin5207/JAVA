package MapTest;

//JDK9新增的一次性添加多个元素
//1. of方法是一个静态方法
//2. 只有List，Set，Map接口拥有，其实现类并没有该方法
//3. 返回值是一个不可变对象
//4. 用于集合中元素确定时，一次性添加，避免多次使用add（）方法
//5. 还要注意Set，Map使用时不能有重复的元素

import java.util.Map;
import java.util.Set;

public class OfTest {
    public static void main(String[] args) {

        Set<String> set = Set.of("abc", "cbd", "abs");
        System.out.println(set);

//        set.add("abc"); // 编译成功，运行弹出异常：不支持操作异常UnsupportedOperationException

        Map<String, Integer> map = Map.of("kylin", 19, "Ysl", 40, "Smq", 18);
        System.out.println(map);
    }
}
