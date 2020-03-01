package IOStreamTest.InputStreamTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
    InputStream:字节输入流
         public void close() :关闭此输入流并释放与此流相关联的任何系统资源。
         public abstract int read() : 从输入流读取数据的下一个字节。
         public int read(byte[] b) : 从输入流中读取一些字节数，并将它们存储到字节数组 b中 。

    FileInputStream:文件输入流
        构造方法：
            FileInputStream(File file) : 通过打开与实际文件的连接来创建一个 FileInputStream ，该文件由文件系统中的 File对象 file命名。
            FileInputStream(String name) : 通过打开与实际文件的连接来创建一个 FileInputStream ，该文件由文件系统中的路径名 name命名。
        读取字节:
             read（），每次可以读取一个字节的数据，提升为int类型，读取到文件末尾，返回-1
             read(byte[] b) ，每次读取b的长度个字节到数组中，返回读取到的有效字节个数，读取到末尾时，返回-1
 */
public class FileInputStreamTest {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("/Users/shangmengqi/Desktop/kylin/JAVA学习/day01-code/src/IOStreamTest/OutputStreamTest/word.txt");

        int b;

        while ((b = fis.read()) != -1){
            //读取到文件末尾的时候，返回值为-1
            System.out.println((char)b);
        }

        fis.close();
    }
}
