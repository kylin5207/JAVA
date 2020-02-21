package ExceptionTest;
/*

Exception编译期异常， 进行编译时程序出现的问题，可以事先处理，保证程序运行
    RuntimeException运行期异常，java程序运行过程中出现的问题
Error：系统异常，必须修改源代码
*/

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) {
        //Exception编译期异常
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date date = sdf.parse("2014-09-20");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //运行时异常
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入两个整数a,b:空格隔开：");

        int a = sc.nextInt();
        int b = sc.nextInt();
        int value;

        try{
            value = a / b;
        } catch(Exception e) {
            //当b为0时，就会出现RuntimeException
            System.out.println("除数不为0！！");
        }

        System.out.println("a和b的商为：" + a/b);

        //Error错误：内存溢出OutOfMemoryError
//        int[] array = new int[1024*1024*1024]; // 必须修改数组大小，程序才能正常运行。
    }
}
