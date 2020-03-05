package FunctionalInterface.SupplierTest;

import java.util.function.Supplier;

/*
    Supplier生产型接口
    java.util.function.Supplier<T>接口仅包含一个无参的方法: T get() 。
    用来获取一个泛型参数指定类型的对象数据。由于这是一个函数式接口，这也就意味着对应的Lambda表达式需要“对外提供”一个符合泛型类型的对象 数据。
 */
public class Demo {
    public static void main(String[] args) {

        System.out.println(getString(()-> "返回值"));

    }

    public static String getString(Supplier<String> supplier) {
        return  supplier.get();
    }
}
