package IOStreamTest.PrintStream;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/*
    平时我们在控制台打印输出，是调用 print 方法和 println 方法完成的.
    这两个方法都来自于 java.io.PrintStream 类，该类能够方便地打印各种数据类型的值，是一种便捷的输出方式
        继承自OutputStream类：
            注意：
                如果使用继承自父类的write（）方法写数据，那么查看数据的时候会查询编码表
                如果使用print/println(), 那么可以写入相应的数据
        特点：
            1. 只负责数据的输出
            2. 永远不会抛出IOException异常
            3. 有特有的方法：print()，println()

    构造方法：
        public PrintStream(String fileName) : 使用指定的文件名创建一个新的打印流

 */
public class PrintStreamTest {
    public static void main(String[] args) throws FileNotFoundException {

        PrintStream ps = new PrintStream("/Users/shangmengqi/Desktop/kylin/JAVA学习/day01-code/src/IOStreamTest/PrintStream/text.txt");

        //使用OutputStream的方法
        ps.write(97);

        //使用print方法
        ps.println(97);
        ps.println(8.8);

        ps.close();

    }
}
