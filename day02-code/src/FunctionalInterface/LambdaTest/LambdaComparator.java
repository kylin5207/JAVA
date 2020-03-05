package FunctionalInterface.LambdaTest;

import java.util.Arrays;
import java.util.Comparator;

/*
    使用lambda表达式作为方法的返回值
        如果一个方法的返回值类型是一个函数式接口，那么就可以直接返回一个Lambda表达式

    案例：
        当需要通过一个方法来获取java.util.Comparator接口类型的对象作为排序器时,就可以调该方法获取。
 */
public class LambdaComparator {
    public static void main(String[] args) {

        String[] arrays = {"aaaa", "bb", "cccccc", "d"};
        System.out.println("排序前的数组：" + Arrays.toString(arrays));

        Arrays.sort(arrays, getCompator());
        System.out.println("排序后的数组：" + Arrays.toString(arrays));


    }

    public static Comparator<String> getCompator() {
        //方法的返回值类型是一个接口，可以返回其匿名内部类
        //按照字符串长度进行降序排序

        return (o1, o2)->(o2.length() - o1.length());
    }
}
