package FunctionalInterface.PredicateTest;

import java.util.Scanner;
import java.util.function.Predicate;

/*
    取反，negate()
 */
public class NegateTest {
    public static void main(String[] args) {

        System.out.println("输入一个字符串：");
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        boolean answer = checkString(s, s1 -> s1.length()>5);

        System.out.println(s + "长度大于5取反 ? " + answer);

    }

    public static boolean checkString(String s, Predicate<String> lengthPredicate) {
    /*
        判断一个字符串是否符合要求，其中有两个条件：
            1. 判读字符串的长度是否大于5
            2. 判断字符串中是否包含a
        只要有一个满足，返回true
     */

        //等价于：!lengthPredicate.test(s)
        return lengthPredicate.negate().test(s);
    }
}
