package IOStreamTest.WriterTest;
/*
    JDK7优化后的 try-with-resource 语句，该语句确保了每个资源在语句结束时关闭。所谓的资源(resource)是指在程序完成后，必须关闭的对象。

     try (创建流对象语句，如果多个,使用';'隔开) {
            // 读写数据
      } catch (IOException e) {
            e.printStackTrace();
      }
*/

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest2 {
    public static void main(String[] args) {

        try (FileWriter fw = new FileWriter("/Users/shangmengqi/Desktop/kylin/JAVA学习/day01-code/src/IOStreamTest/WriterTest/word.txt"))
        {
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


    }
}
