package CollectionTest.SetTest.HashCodeTest;
/*
Object类的hashCode()可以获取对象的哈希地址
toString方法默认使用的也是hashCode的十六进制
*/
public class HashCodeTest {
    public static void main(String[] args) {
        Person person1 = new Person("Ysl");
        System.out.println("person1的哈希值："+person1.hashCode());
        System.out.println("person1.toString()："+person1.toString());
        System.out.println("HashCode转换为16进制："+Integer.toHexString(person1.hashCode()));

        //可以发现toString的后半部分，就是hashCode的十六进制表示形式
        Person person2 = new Person("Smq");
        System.out.println("person2的哈希值："+person2.hashCode());
        System.out.println("person2.toString()："+person2.toString());
        System.out.println("hashCode转换为16进制："+Integer.toHexString(person2.hashCode()));

        //哈希值只表示逻辑地址，而不是物理地址
        System.out.println("person1 == person2?"+(person1 == person2));


    }
}
