package CollectionTest.SetTest.HashCodeTest;

import java.util.HashSet;

/*
    使用HashSet集合存储自定义类Person，记得重写hashCode（）和equals（）方法，用于比较对象是否相同
 */
public class PersonHashSetTest {
    public static void main(String[] args) {

        //创建两个属性相同的对象，一个不同的对象
        Person person1 = new Person("Kylin", 18);
        Person person2 = new Person("Kylin", 18);
        Person person3 = new Person("Ysl",29);

        //创建HashSet对象，将三个person对象放入
        HashSet<Person> personSet = new HashSet<>();
        personSet.add(person1);
        personSet.add(person2);
        personSet.add(person3);

        //如果没有重写HashCode和equals方法，则三个的hashCode是不同的
        //如果重写之后，hashCode是相同的
        System.out.println("---------输入各个对象的哈希值---------");
        System.out.println("person1的hashCode：" + person1.hashCode());
        System.out.println("person2的hashCode：" + person2.hashCode());
        System.out.println("person3的hashCode：" + person3.hashCode());

        System.out.println("-------对象间的equals方法--------");
        System.out.println("person1.equals(person2)：" + person1.equals(person2));
        System.out.println("person1.equals(person3)：" + person1.equals(person3));

        System.out.println("-------对象实际物理地址的比较--------");
        //哈希值是逻辑地址，而不是物理地址，person1和person2的哈希值虽然相同，但是存储的物理地址是不同的
        System.out.println("person1 == person2?" + (person1 == person2));

        System.out.println("--------HashSet集合元素----------");
        System.out.println(personSet);

    }
}
