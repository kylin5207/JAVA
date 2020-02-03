package ArrayTest;

import java.util.Arrays;

public class ArrayTraverse {
    public static void main(String[] args) {

        int[] array = {1,2,3,4,5};

//        1.普通遍历方式
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();

//        2. 使用Arrays类的toString方法
        System.out.println(Arrays.toString(array));

    }
}
