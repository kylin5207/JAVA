package IOStreamTest.InputStreamTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
    图片复制练习
    从已知文件中读取字节，写入到另一个文件中
 */
public class FileCopy {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("/Users/shangmengqi/Desktop/kylin/JAVA学习/day01-code/pic/buding.jpeg");
        FileOutputStream fos = new FileOutputStream("/Users/shangmengqi/Desktop/kylin/JAVA学习/day01-code/src/IOStreamTest/InputStreamTest/pic.jpeg");

        byte[] bytes = new byte[1024];
        int len;

        long start = System.currentTimeMillis();

        while((len = fis.read(bytes)) != -1)
        {
            fos.write(bytes, 0, len);
        }

        //先关outputSream，后关inputStream
        fos.close();

        fis.close();

        long end = System.currentTimeMillis();
        System.out.println("复制图片耗时：" + (end - start) + "ms");
    }
}
