package IOStreamTest.WriterTest;

/*
    JDK1.7以前，流异常处理的方式
 */

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {
    public static void main(String[] args) {
        //JDK1.7以前，流异常的处理方式
        FileWriter fw = null;
        try{
            fw = new FileWriter("/Users/shangmengqi/Desktop/kylin/JAVA学习/day01-code/src/IOStreamTest/WriterTest/word.txt");

            //写入单个字符
            fw.write(97);
            fw.flush();//刷新数据到文件中

            //写入字符串
            fw.write("kylin");

            //写入字符数组
            fw.write("帅气".toCharArray());
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        finally {
            if(fw != null) {
                try{
                    fw.close(); //会抛出IOException异常
                }
                catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }

        }

    }
}
