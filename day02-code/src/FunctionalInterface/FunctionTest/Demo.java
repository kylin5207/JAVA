package FunctionalInterface.FunctionTest;

import java.util.function.Function;

/*
    java.util.function.Function<T,R> 接口用来根据一个类型的数据得到另一个类型的数据，前者称为前置条件，后者称为后置条件。

    Function 接口中最主要的抽象方法为: R apply(T t) ，根据类型T的参数获取类型R的结果
    Function 接口中有一个默认的 andThen()方法，用来进行组合操作
    例如：将 String 类型转换为 Integer 类型
 */
public class Demo {
    public static void main(String[] args) {
        String num = "121";

        convertType(num, n-> Integer.parseInt(n));


    }

    public static void convertType(String s, Function<String,Integer> function) {
        Integer in = function.apply(s); //自动拆箱
        System.out.println("转换后的Integer：" + in);
    }
}
