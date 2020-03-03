package IOStreamTest.OutputStreamTest;

import java.io.*;
import java.util.ArrayList;

/*
    序列化集合
        当我们想再文件中保存多个对象的时候，可以把多个对象存储在一个集合中，对集合进行序列化和反序列化
        1. 将存有多个自定义对象的集合序列化操作，保存到 list.txt 文件中。
        2. 反序列化 list.txt ，并遍历集合，打印对象信息。
 */
public class SerialCollectionTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //将对象存储在数组列表中
        ArrayList<Person> peoplelist = new ArrayList<>();
        peoplelist.add(new Person("Kylin", 20));
        peoplelist.add(new Person("Mq", 18));
        peoplelist.add(new Person("丑林", 30));

        //使用输出流存储到硬盘中
        FileOutputStream fos = new FileOutputStream("/Users/shangmengqi/Desktop/kylin/JAVA学习/day01-code/src/IOStreamTest/OutputStreamTest/Personlist.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(peoplelist);

        oos.close();

        //使用反序列化读出
        FileInputStream fis = new FileInputStream("/Users/shangmengqi/Desktop/kylin/JAVA学习/day01-code/src/IOStreamTest/OutputStreamTest/Personlist.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);

        Object obj = ois.readObject();

        ois.close();

        ArrayList<Person> list = (ArrayList<Person>)obj;

        for (Person person : list) {
            System.out.println(person);
        }


    }
}
