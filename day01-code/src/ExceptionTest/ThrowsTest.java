package ExceptionTest;

/*
    关键字throws运用于方法声明之上,用于表示当前方法不处理异常,而是提醒该方法的调用者来处理异常(抛出异常)
    注意：
     1。 throws关键字后面的声明异常必须是Exception或者其子类
     2。 对于方法体内抛出的多个异常，throws后要加相应的异常类
        如果这些异常类之间有继承关系，则只用声明父类即可
 */

import java.io.FileNotFoundException;
import java.io.IOException;

public class ThrowsTest {
    public static void main(String[] args) throws IOException {

        readFile("c:\\b.txt"); //抛出编译异常，这里没有处理，则方法外继续抛出该异常

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
