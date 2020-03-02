package IOStreamTest;

import java.io.*;

/*
    转换输入流 ：java.io.InputStreamReader
        1. 是Reader的子类，是从字节流到字符流的桥梁。
        2. 它读取字节，并使用指定的字符集将其解码为字符。它的字符集可以由名称指定，也可以接受平台的默认字符集。

        构造方法：
          InputStreamReader(InputStream in) : 创建一个使用默认字符集的字符流。
         InputStreamReader(InputStream in, String charsetName) : 创建一个指定字符集的字符流。

     转换输出流：java.io.InputStreamWriter
        1. Writer的子类，是字符流到字节流的桥梁
        OutputStreamWriter(OutputStream in) : 创建一个使用默认字符集的字符流。
        OutputStreamWriter(OutputStream in, String charsetName) : 创建一个指定字符集的字符流。

 */
public class InputStreamReaderTest {
    public static void main(String[] args) throws IOException {

        //使用gbk编码写入文件
        String filename = "/Users/shangmengqi/Desktop/kylin/JAVA学习/day01-code/src/IOStreamTest/text.txt";
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(filename), "gbk");

        osw.write("你好");

        osw.flush();

        osw.close();

        //使用InputStreamReader解码(解码方式与文件编码方式相同，否则还是会乱码)
        InputStreamReader isr = new InputStreamReader(new FileInputStream(filename), "gbk");

        int len;
        while((len = isr.read()) != -1) {
            System.out.print((char)len);
        }

        isr.close();
    }
}
