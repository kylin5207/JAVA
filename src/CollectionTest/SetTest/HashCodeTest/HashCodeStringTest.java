package CollectionTest.SetTest.HashCodeTest;

/*
    String类重写的Object类的hashCode()方法
*/
public class HashCodeStringTest {
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "abc";

        //可以发现，字符串内容相同，则hashCode相同
        System.out.println(str1 + "的哈希值：" + str1.hashCode());
        System.out.println(str2 + "的哈希值" + str2.hashCode());
    }
}
