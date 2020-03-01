package IOStreamTest.InputStreamTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

/*
    字节输入流一次读取多个字节
    read(byte[] b) ，每次读取b的长度个字节到数组中，返回读取到的有效字节个数，读取到末尾时，返回-1

    使用数组读取，每次读取多个字节，减少了系统间的IO操作次数，从而提高了读写的效率，建议开发中使用。

    明确两个事情：
        1. byte[]数组的作用：
            缓冲作用，可存储每次读取的多个字节
            数组的长度一般定义为1024（1KB）的整数倍
        2. 返回值表示有效读取的字节长度
 */
public class FileInputStreamTest2 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("/Users/shangmengqi/Desktop/kylin/JAVA学习/day01-code/src/IOStreamTest/OutputStreamTest/word.txt");

        byte[] b = new byte[2];
        int len; //记录读取的字节数

        while ((len = fis.read(b)) != -1){
            //读取到文件末尾的时候，返回值为-1
            System.out.println(new String(b,0,len));
        }

        fis.close();
    }
}
