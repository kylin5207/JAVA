package IOStreamTest;

import java.io.*;

/*
    将GBK编码的文本文件，转换为UTF-8编码的文本文件。
    1. 利用gbk编码读取该文件
    2. 再利用utf-8编码该文件，写入到新文件中
 */
public class TransformCoding {
    public static void main(String[] args) throws IOException {
        String filename = "/Users/shangmengqi/Desktop/kylin/JAVA学习/day01-code/src/IOStreamTest/text.txt";
        String writename = "/Users/shangmengqi/Desktop/kylin/JAVA学习/day01-code/src/IOStreamTest/text2.txt";
        InputStreamReader isr = new InputStreamReader(new FileInputStream(filename), "gbk");
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(writename), "utf-8");

        int len;
        while ((len = isr.read()) != -1){
            osw.write(len);
        }

        osw.close();
        isr.close();
    }
}
