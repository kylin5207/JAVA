package IOStreamTest.WriterTest;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/*
    BufferedWriter字符输出流：
        1。 继承了Writer
        2。 特殊方法：
            BufferedReader: public String readLine() : 读一行文字。
            BufferedWriter: public void newLine() : 写一行行分隔符,由系统属性定义符号
 */
public class BufferedWriterTest {
    public static void main(String[] args) throws IOException {

        FileWriter fw = new FileWriter("/Users/shangmengqi/Desktop/kylin/JAVA学习/day01-code/src/IOStreamTest/WriterTest/word2.txt",true);
        BufferedWriter bw = new BufferedWriter(fw);

        bw.write("kylin");

        bw.newLine();

        bw.write("帅琦");

        bw.flush();

        bw.close();


    }
}
