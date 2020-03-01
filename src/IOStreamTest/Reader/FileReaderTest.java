package IOStreamTest.Reader;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("/Users/shangmengqi/Desktop/kylin/JAVA学习/day01-code/src/IOStreamTest/Reader/word.txt");

        char[] chars = new char[2];

        int len;

//        while((len = fr.read()) != -1) {
//            System.out.print((char)len);
//        }

        while((len = fr.read(chars)) != -1) {
            System.out.print(new String(chars, 0, len));
        }

        fr.close();
    }
}
