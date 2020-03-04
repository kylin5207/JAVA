package FunctionalInterface;

/*
    函数式接口：只包含一个抽象方法的接口

     @FunctionalInterface注解：
        一旦使用该注解来定义接口，编译器将会强制检查该接口是否确实有且仅有一个抽象方法，否则将会报错。
        需要注意的是，即使不使用该注解，只要满足函数式接口的定义，这仍然是一个函数式接口，使用起来都一样。
 */
@FunctionalInterface
public interface MyInterface {
    public  abstract void method();
}
