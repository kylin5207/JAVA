package IOStreamTest.Reader;

import java.io.*;
import java.util.HashMap;

/*
    文本排序练习：
        1. 逐行读取文本信息。
        2. 解析文本信息到集合中。
        3. 遍历集合，按顺序，写出文本信息。

 */
public class ParaSort {
    public static void main(String[] args) throws IOException {

        //1 利用hashmap存储每行的内容，键用于存储标号，值用于存储文本内容
        HashMap<String, String> map = new HashMap<>();

        //2 创建各种流
        FileReader fr = new FileReader("/Users/shangmengqi/Desktop/kylin/JAVA学习/day01-code/src/IOStreamTest/Reader/passage.txt");
        BufferedReader br = new BufferedReader(fr);

        FileWriter fw = new FileWriter("/Users/shangmengqi/Desktop/kylin/JAVA学习/day01-code/src/IOStreamTest/Reader/order_passage.txt");
        BufferedWriter bw = new BufferedWriter(fw);

        String line = null;

        //3. 读取文件中的内容
        while ((line = br.readLine()) != null) {
            String[] strings = line.split("\\.");
            map.put(strings[0], strings[1]);
        }

        //输入流可以关掉。
        br.close();

        //遍历HashMap集合，将其写入到order_passage写入
        for (String s : map.keySet()) {
            String key = s;
            String value = map.get(key);

            line = key + "." + value;

            bw.write(line);
            bw.newLine();
        }

        bw.close();

    }
}
