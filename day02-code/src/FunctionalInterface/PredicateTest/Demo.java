package FunctionalInterface.PredicateTest;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Scanner;
import java.util.function.Predicate;

/*
    java.util.function.Predicate<T> 接口:
        对某种类型的数据进行判断，从而得到一个boolean值结果。
    方法：
        public abstract boolean test(T t):返回条件返回true，否则返回false

 */
public class Demo {
    public static void main(String[] args) {
        System.out.println("输入一个字符串：");
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        //判断输入的字符串是否是"Disney"
        boolean answer = checkString(s, string->string.equals("Disney"));
        System.out.println(s + " == Disney ? " + answer);

        //判断输入的字符串长度是否大于5
        boolean answer2 = checkString(s, string->string.length()>5);
        System.out.println(s + ".length > 5 ? " + answer2);

    }

    public static boolean checkString(String s, Predicate<String> predicate) {
        //判断字符串与给定值是否相同
        return predicate.test(s);
    }
}
