package LambdaTest;

import java.util.Scanner;

/*
    lambda有参数有返回值练习：

    给定一个计算器 Calculator 接口，内含抽象方法 calc 可以将两个int数字相加得到和值
 */
interface Calculator{
    int calc(int num1, int num2);
}
public class Test3 {
    public static void main(String[] args) {

        System.out.println("请输入两个整数，用空格隔开：");

        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        invokeCalc(num1, num2, (int a, int b) -> {return a + b;});


    }
    public static void invokeCalc(int num1, int num2, Calculator cal){
        int sum = cal.calc(num1,num2);

        System.out.println(sum);
    }
}
