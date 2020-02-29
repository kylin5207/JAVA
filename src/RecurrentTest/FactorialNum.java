package RecurrentTest;

import java.util.Scanner;

/*
    递归求阶乘
 */
public class FactorialNum {
    public static void main(String[] args) {

        System.out.println("请输入要计算阶乘的n：");

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int s = getFactorial(n);

        System.out.println(n + "! : " + s);

    }

    public static int getFactorial(int n) {
        if(n == 1) {
            return 1;
        }
        return n * getFactorial(n-1);
    }
}
