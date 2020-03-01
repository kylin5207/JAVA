package IOStreamTest.OutputStreamTest;

/*
    数据追加续写：
         public FileOutputStream(File file, boolean append) : 创建文件输出流以写入由指定的File对象表示的文件。
         public FileOutputStream(String name, boolean append) : 创建文件输出流以指定的名称写入文件。
         这两个构造方法，参数中都需要传入一个boolean类型的值， true 表示追加数据， false 表示清空原有数据。

    数据换行：
         Windows系统里，每行结尾是 回车+换行 ，即 \r\n ;
         Unix系统里，每行结尾只有 换行 ，即 \n ;
         Mac系统里，每行结尾是 回车 ，即 \r 。从 Mac OS X开始与Linux统一

 */

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputTest2 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("/Users/shangmengqi/Desktop/kylin/JAVA学习/day01-code/src/IOStreamTest/OutputStreamTest/word.txt",true);

        byte[] bytes = {97, 98, 99, 100, 101};

        for (int i = 0; i < bytes.length; i++) {
            fos.write(bytes[i]);
            fos.write("\n".getBytes());
        }

        fos.close();

    }
}
