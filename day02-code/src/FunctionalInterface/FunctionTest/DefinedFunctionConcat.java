package FunctionalInterface.FunctionTest;
/*
    请使用 Function 进行函数模型的拼接，按照顺序需要执行的多个函数操作为:
        String str = "赵丽颖,20";
         1. 将字符串截取数字年龄部分，得到字符串;
         2. 将上一步的字符串转换成为int类型的数字;
         3. 将上一步的int数字累加100，得到结果int数字。
 */

import java.util.function.Function;

public class DefinedFunctionConcat {
    public static void main(String[] args) {
        String string = "赵丽颖,20";

        convertString(string, s -> s.split(",")[1], s -> Integer.parseInt(s), n -> n + 100);

    }

    public static void convertString(String string, Function<String,String> function1, Function<String, Integer> function2, Function<Integer,Integer> function3) {
        int num = function1.andThen(function2).andThen(function3).apply(string);
        System.out.println(num);
    }
}
