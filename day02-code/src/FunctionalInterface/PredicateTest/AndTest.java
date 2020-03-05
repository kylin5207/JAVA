package FunctionalInterface.PredicateTest;

import java.util.Scanner;
import java.util.function.Predicate;

/*
    既然是条件判断，就会存在与、或、非三种常见的逻辑关系。
    其中将两个Predicate条件使用“与”逻辑连接起来实现“并且”的效果时，可以使用default方法and() 。

    同理，or()实现或，negate()实现非
 */
public class AndTest {
    public static void main(String[] args) {

        System.out.println("输入一个字符串：");
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        boolean answer = checkString(s, s1 -> s1.length()>5, s1 -> s1.contains("a"));

        System.out.println(s + "长度大于5，并且包含a ? " + answer);

    }

    public static boolean checkString(String s, Predicate<String> lengthPredicate, Predicate<String> letterPredicate) {
    /*
        判断一个字符串是否符合要求，其中有两个条件：
            1. 判读字符串的长度是否大于5
            2. 判断字符串中是否包含a
        同时满足，返回true
     */

        //等价于：lengthPredicate.test(s) && letterPredicate.test(s)
        return lengthPredicate.and(letterPredicate).test(s);
    }

}
