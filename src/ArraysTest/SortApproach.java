package ArraysTest;

import java.util.Arrays;
import java.util.Scanner;

//用 Arrays 相关的API，将一个随机字符串中的所有字符升序排列，逆序输出

public class SortApproach {

    public static void main(String[] args) {

//        1. 输入字符串
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入随机的字符串：");
        String string = sc.next();

//        2. 将字符串转换为字符数组
        char[] chars = string.toCharArray();

//        3. 使用Arrays的sort方法对数组进行排序
        Arrays.sort(chars);

//        4. 逆序输出(利用chars.forr)
        for (int i = chars.length - 1; i >= 0; i--) {
            System.out.println(chars[i]);
        }
    }

}
