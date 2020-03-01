package IOStreamTest.OutputStreamTest;
/*
    字节输出流的使用步骤：
        1. 创建一个FileOutputStream对象，构造方法中传递写入数据的目的地
        2. 调用FileOutputStream对象中的write（）方法写入数据到文件中
        3. 调用close（）关闭流，释放资源
 */

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class FileOutputTest {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("/Users/shangmengqi/Desktop/kylin/JAVA学习/day01-code/src/IOStreamTest/OutputStreamTest/word.txt");

        //写入单个字节
        //fos.write(97); //写入a

        //写入字节数组(写入100，三个字节)
        byte[] bytes = {49, 48, 48};
        fos.write(bytes);

        //写入中文字符（一个中文=2字节，第一个字节是负数）
//        byte[] chinese = {-65, -66};
//        fos.write(chinese);

        //写入指定的字符串
        byte[] str_bytes = "我爱龙猫".getBytes();
        System.out.println(Arrays.toString(str_bytes));
        fos.write(str_bytes);

        //写字节数组的一部分
        byte[] str2_bytes = "Kylin梦琦".getBytes();
        fos.write(str2_bytes,5, 6);
        fos.close();


    }
}
