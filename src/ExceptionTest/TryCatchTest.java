package ExceptionTest;

/*
    try...catch...：自行处理异常，捕获异常机制
        格式：
            try{
                可能出现异常的代码块
            }
            catch(异常类 变量名){
                处理异常：一般将异常的信息记录保存到日志中
            }
            ... // 可以有多个catch
            catch(异常类 变量名){
            }
         注意：
            如果try中出现了异常，就会执行catch中的异常处理逻辑，之后继续执行try...catch之后的代码
            如果try未出现异常，则不会执行catch中的异常处理逻辑，程序继续向后运行
*/

import java.io.FileNotFoundException;
import java.io.IOException;

public class TryCatchTest {
    public static void main(String[] args) {
        try{
            readFile("d:\\a.txt");
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        System.out.println("程序运行完毕");
    }

    public static void readFile(String filename) throws IOException { //注意：FileNotFoundException是IOException的子类，所以在这里只用其父类即可
        //对传递文件的路径进行合法性判断
        if(! filename.equals("c:\\a.txt")) {
            throw new FileNotFoundException("文件路径有误，不是c:\\a.txt"); //FileNotFoundException是一个编译异常
        }

        if (!filename.endsWith(".txt")) {
            throw new IOException("文件后缀名有误");

        }
    }
}
