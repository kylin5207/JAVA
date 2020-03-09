package FunctionalInterface.MethodQuote.Demo;

/*
    双冒号:: 为引用运算符，而它所在的表达式被称为方法引用。
    如果Lambda要表达的函数方案已经存在于某个方法的实现中，那么则可以通过双冒号来引用该方法作为Lambda的替代者
        注意：
            1. Lambda中传递的参数一定是方法引用中的那个方法可以接收的类型,否则会抛出异常
            2. 方法引用的前提是对象存在

 */
public class Demo {
    public static void main(String[] args) {

        String s = "Kylin";

        //使用lambda表达式
        method(s, string -> System.out.println(string.toUpperCase()));

        //使用方法引用
        Methoder methoder = new Methoder(); //方法引用的前提是对象一定要存在
        method(s, methoder::print);

    }

    public static void method(String s, PrintString p) {
        p.printstring(s);
    }
}
