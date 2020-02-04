package RandomTest;

import java.util.Random;

public class RandomNextInt {

    public static void main(String[] args) {

        Random r = new Random();

//        1. 使用不带参数的nextInt（）方法，有正有负
        int num1 = r.nextInt();
        System.out.println("使用默认不带参数的nextInt（）得到的是int所有范围内的随机数"+num1);

//        2. 使用带int参数的nextInt（）方法
        int num2 = r.nextInt(10);
        System.out.println("使用参数为10的nextInt()方法生产的随机数是："+num2);

    }

}
