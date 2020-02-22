package ExceptionTest;

import ArrayTest.OutOfBoundsException;

/*
    throw关键字：
        作用：在指定的方法中抛出指定的异常
        格式：
            throw new XXException(参数)；
        注意：
            1。 throw关键字写在方法体内部
            2。 throw关键字后面的对象必须是Exception或者其子类对象
            3。 throw关键字抛出指定的异常对象，就需要处理这个异常对象
                如果该异常是RuntimeException或者是其子类对象，可以不处理，默认交给JVM处理（JVM会打印异常对象，中断程序）
                如果该异常是编译异常，就必须处理这个异常，或者throws，或者用try...catch
*/
public class ThrowTest {
    public static void main(String[] args) {
        int[] array1 = {1,2,3,4,5};
        System.out.println("array1数组的第2个元素是：" + getElement(array1, 1));

//        int[] array2 = null;
//        System.out.println("array2数组的第3个元素是" + getElement(array2, 2));

        System.out.println("array1数组的第3个元素是" + getElement(array1, 5));


    }

    public static int getElement(int[] array, int index) {
        /*
            获取array数组在index处的相应值
        */
//    对于方法传递过来的参数，一定要进行合法性校验，如果不合法，使用抛出异常的方式告知调用者（提示方法有问题）
        if(array == null){
            throw new NullPointerException("当前数组为空"); //NullPointerEception异常是运行期异常，可以交给JVM处理
        }
        else if(index < 0 || index >= array.length) {
            throw new ArrayIndexOutOfBoundsException("数组索引越界啦"); //ArrayIndexOUtOfBoundsException也是一个运行期异常
        }

        return array[index];


    }
}
