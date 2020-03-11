package AnnotationTest;

/**
 *
 *     注解javadoc演示：
 *     @author kylin
 *     @version 1.0
 *     @since 2020/3/11
 *
 *
 */
/*
    JDK中预定义的⼀一些注解
    @Override :检测被该注解标注的方法是否是继承⾃父类(接口)的 *
    @Deprecated:该注解标注的内容，表示已过时
    @SuppressWarnings:压制警告,一般写在类定义上
        一般传递参数all @SuppressWarnings("all")

 */

@SuppressWarnings("all")

public class JavaDocTest {
    public static void main(String[] args) {

    }

    /**
     *
     * @param a
     * @param b
     * @return a+b
     */

    public static int add(int a, int b) {
        return a + b;
    }
}
