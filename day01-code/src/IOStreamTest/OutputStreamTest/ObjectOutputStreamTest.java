package IOStreamTest.OutputStreamTest;
/*
    对象序列化
    java.io.ObjectOutputStream类，将Java对象的原始数据类型写出到文件,实现对象的持久存储。
        构造方法：
            public ObjectOutputStream(OutputStream out) : 创建一个指定OutputStream的ObjectOutputStream

        写对象方法：
            void writeObject(Object obj)

    一个类要想实现序列化，必须满足两个条件：
        1. 该类必须实现java.io.Serializable接口， Serializable是一个标记接口，不实现此接口的类将不会使任何状态序列化或反序列化，会抛出 NotSerializableException 。
        2. 该类的所有属性必须是可序列化的。如果有一个属性不需要可序列化的，则该属性必须注明是瞬态的，使用transient 关键字修饰

 */

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectOutputStreamTest {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("/Users/shangmengqi/Desktop/kylin/JAVA学习/day01-code/src/IOStreamTest/OutputStreamTest/Person.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(new Person("kylin", 18));

        oos.close();

    }
}
