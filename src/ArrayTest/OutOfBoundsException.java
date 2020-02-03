package ArrayTest;

//测试数组索引越界异常

public class OutOfBoundsException {
    public static void main(String[] args) {

        int[] array = new int[2];

        array[0] = 1;
        array[1] = 2;

        System.out.println(array[0]);
        System.out.println(array[1]);

//        出现越界异常，访问到不存在到索引
        System.out.println(array[2]);


    }
}
