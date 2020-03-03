package RecurrentTest;

/*
    递归计算1 ~ n的和
    不推荐哦，效率太低了
 */


import java.util.Scanner;

public class SumNum {
    public static void main(String[] args) {

        System.out.println("请输入您要计算的前n项和的最后一个数字：");

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long time1 = System.currentTimeMillis();

        int s = getSum(n);

        long time2 = System.currentTimeMillis();

        long recurrent_runtime = (time2 - time1);

        System.out.println("1-" + n + "的和是：" + s);
        System.out.println("运行时间：" + recurrent_runtime + "ms");
    }

    public static int getSum(int n) {
        if (n == 1) {
            return 1;
        }
        return n + getSum(n - 1);
    }
}
