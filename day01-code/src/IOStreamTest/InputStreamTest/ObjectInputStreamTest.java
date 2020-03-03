package IOStreamTest.InputStreamTest;

import IOStreamTest.OutputStreamTest.Person;

import java.io.*;

/*
    ObjectInputStream反序列化流:
        将之前使用ObjectOutputStream序列化的原始数据恢复为对象。
        构造方法：
            public ObjectInputStream(InputStream in) : 创建一个指定InputStream的ObjectInputStream。
        1. 如果能找到一个对象的class文件，我们可以进行反序列化操作，调用 ObjectInputStream 读取对象的方法:
                    public final Object readObject () : 读取一个对象。
        2. 另外，当JVM反序列化对象时，能找到class文件，但是class文件在序列化对象之后发生了修改，那么反序列化操作也会失败，抛出一个InvalidClassException异常
            Serializable 接口给需要序列化的类，提供了一个序列版本号。
                无论是否对类的定义进行修改，都不重新生成新的序列号，手动添加一个序列号
                    private static final long serialVersionUID = xxx;

    反序列化前提；
        1. 类必须实现Serializable接口
        2. 必须存在类对应的class文件
 */
public class ObjectInputStreamTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        FileInputStream fis = new FileInputStream("/Users/shangmengqi/Desktop/kylin/JAVA学习/day01-code/src/IOStreamTest/OutputStreamTest/Person.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);

        Person person = (Person) ois.readObject();

        ois.close();

        System.out.println(person);
    }
}
