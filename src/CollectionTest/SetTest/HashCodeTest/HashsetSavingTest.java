package CollectionTest.SetTest.HashCodeTest;

/*
    给HashSet中存放自定义类型元素时，需要重写对象中的hashCode和equals方法，建立自己的比较方式，才能保证HashSet集合中的对象唯一
    set集合在调用add()方法时，会调用元素的hashCode()方法和equals()方法，判断元素是否重复
*/
import java.util.HashSet;

public class HashsetSavingTest {
    public static void main(String[] args) {
        //创建HashSet集合对象
        HashSet<String> set = new HashSet<>();
        String s1 = "abc";
        String s2 = "eee";
        String s3 = "abc";
        set.add(s1);
        set.add(s2);
        set.add(s3);
        set.add("重地");
        set.add("通话");

        System.out.println("Set集合中的元素："+set);

    }
}
