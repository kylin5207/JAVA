package FunctionalInterface.FunctionTest;

/*
        Function 接口中有一个默认的 andThen()方法，用来进行组合操作
        例如：
            将 String 类型转换为 Integer 类型，之后加10再转换为String类型

 */

import java.util.function.Function;

public class AndThenTest {
    public static void main(String[] args) {

        String s = "123";

        convertType(s, string -> Integer.parseInt(s), num -> num + 10 + "");

    }

    public static void convertType(String s, Function<String,Integer> function1, Function<Integer,String> function2) {

        String numstr = function1.andThen(function2).apply(s);
        System.out.println(numstr);
    }
}
