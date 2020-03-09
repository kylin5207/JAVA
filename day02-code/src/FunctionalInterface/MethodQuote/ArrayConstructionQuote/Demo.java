package FunctionalInterface.MethodQuote.ArrayConstructionQuote;

/*
    数组的构造器引用:
        数组类型[]::new
        注意：
            需要已知数组的类型、以及数组的长度
 */

public class Demo {
    public static void main(String[] args) {

        //使用lambda表达式创建数组
//        int[] array1 = createArray(10, (length -> new int[length]));
//        System.out.println(array1.length);

        //使用方法引用
        int[] array2 = createArray(5, int[]::new);
        System.out.println(array2.length);

    }

    public static int[] createArray(int length, ArrayBuilder ab) {
        return ab.buildArray(length);
    }
}
