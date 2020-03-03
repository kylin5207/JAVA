package IOStreamTest.OutputStreamTest;
/*
    字节缓冲输出流测试

    构造方法：
        public BufferedOutputStream(OutputStream out) : 创建一个新的缓冲输出流。
        public BufferedOutputStream(OutputStream out， int size) : 指定内部缓冲流大小，创建一个新的缓冲输出流。

    使用方法：
        1. 创建字节输出流对象
        2. 利用该对象创建缓冲流对象
        3. 使用BufferedOutputStream写入到内部缓冲区中
        4. 使用BufferedOutputStream中的flush（），将缓冲区的数据刷新到文件中
        5. close()

 */

import java.io.*;

public class BufferedOutputStreamTest {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("/Users/shangmengqi/Desktop/kylin/JAVA学习/day01-code/src/IOStreamTest/OutputStreamTest/bigfile.mp4");
        FileOutputStream fos = new FileOutputStream("/Users/shangmengqi/Desktop/kylin/JAVA学习/day01-code/src/IOStreamTest/OutputStreamTest/bigfile_copy.mp4");

        BufferedInputStream bis = new BufferedInputStream(fis,1024);
        BufferedOutputStream bos = new BufferedOutputStream(fos,1024);

        int len;
        byte[] bytes = new byte[1024];

        /*首先计算不使用输出流复制的时间


        //计算起始时间
        long start = System.currentTimeMillis();

        while((len = fis.read(bytes)) != -1){

                fos.write(bytes,0,len);
        }

        //计算复制完成的时间
        long end = System.currentTimeMillis();

        System.out.println("普通字节流复制完成时间：" + (end - start) + "ms"); //输出613ms
        */

        long start = System.currentTimeMillis();

        while((len = bis.read(bytes)) != -1){

            bos.write(bytes,0,len);
        }

        long end = System.currentTimeMillis();

        System.out.println("使用字节缓冲流复制完成时间：" + (end - start) + "ms"); //输出390ms

        //资源释放，只需要关闭缓冲流，自动关闭基本流
        bos.close();
        bis.close();


    }
}
