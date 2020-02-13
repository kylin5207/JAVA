package CollectionTest.ComparableTest;

import java.util.ArrayList;
import java.util.Collections;

public class PersonTest {
    public static void main(String[] args) {
        ArrayList<Person> list = new ArrayList<>();

        Person person1 = new Person("Kylin", 18);
        Person person2 = new Person("Ysl", 24);
        Person person3 = new Person("Smq", 16);

        list.add(person1);
        list.add(person2);
        list.add(person3);

        System.out.println("list：" + list); //默认按照存入顺序输出

        Collections.sort(list);
        System.out.println("使用默认的sort排序：" + list);



    }
}
