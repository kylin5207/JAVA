package IOStreamTest.Reader;

import java.io.*;

/*
    字符缓冲输入流测试：
        特殊方法：
            public String readLine(): 读取一行文字，不包含终止符号\n
                当读取到末尾时，返回null
 */
public class BufferedReaderTest {
    public static void main(String[] args) throws IOException {

        FileReader fr = new FileReader("/Users/shangmengqi/Desktop/kylin/JAVA学习/day01-code/src/IOStreamTest/WriterTest/word2.txt");
        BufferedReader br = new BufferedReader(fr);

        String line = null;

        while((line = br.readLine()) != null) {
            System.out.println(line);
        }

        br.close();
    }
}
