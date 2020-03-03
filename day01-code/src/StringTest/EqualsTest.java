package StringTest;

public class EqualsTest {

    public static void main(String[] args) {

//        "hello"字符串放在字符串常量池中，s1和s2指向相同的地址
        String s1 = "hello";
        String s2 = "hello";

        String s3 = new String("Hello");

//        ==比较引用类型数据时，判断的是两个地址是否相等
        System.out.println("s1 == s2 ?:" + (s1 == s2));
        System.out.println("s1 == s3 ?:" + (s1 == s3));

//        euqals()方法比较两个字符串的内容是否相同
        System.out.println("s1.equals(s2):" + s1.equals(s2));
        System.out.println("s1.equals(s3):" + s1.equals(s3));

//        equalsIgnoreCase()方法比较字符串内容相等时，忽略大小写
        System.out.println("s1.equalsIgnoreCase(s3):" + s1.equalsIgnoreCase(s3));
        System.out.println("s1.equalsIgnoreCase(s3):" + s1.equalsIgnoreCase(s3));


    }

}
