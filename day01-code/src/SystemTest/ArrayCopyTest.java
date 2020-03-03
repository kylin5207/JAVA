package SystemTest;

//将src数组中前3个元素，复制到dest数组的前3个位置上复制元素前:
// src数组元素 [1,2,3,4,5]
// dest数组元素[6,7,8,9,10]

import java.util.Arrays;

public class ArrayCopyTest {
    public static void main(String[] args) {
        int[] src = {1, 2, 3, 4, 5};
        int[] dest = {6, 7, 8, 9, 10};

        System.arraycopy(src,0, dest, 0, 3);

        System.out.println(Arrays.toString(dest));
    }
}
