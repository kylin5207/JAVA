package IOStreamTest.PrintStream;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/*
    System.out就是PrintStream类型的，只不过它的流向是系统规定的，打印在控制台上。不过，既然是流对象，我们就可以玩一个"小把戏"，改变它的流向。

    System.setOut()可以改变输出语句的目的地为参数传递的流的目的地

 */
public class ChangeDirection {
    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("控制台console输出：Hello");

        PrintStream ps = new PrintStream("/Users/shangmengqi/Desktop/kylin/JAVA学习/day01-code/src/IOStreamTest/PrintStream/text.txt");

        System.setOut(ps); //改变输出的流向
        System.out.println("Hello, I'm here. Not in the console, just in your file");

        ps.close();
    }
}
