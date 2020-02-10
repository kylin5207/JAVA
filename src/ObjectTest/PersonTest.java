package ObjectTest;

public class PersonTest {
    public static void main(String[] args) {

        Person person = new Person();
        Person person0 = new Person();

//        使用默认的toString，即object类的toString()和直接print(对象名的效果一样)
//        输出值：对象类名@地址
        System.out.println("--------默认toString（）--------");
        System.out.println(person.toString());
        System.out.println(person);

        PersonRedefinition person1 = new PersonRedefinition("Ysl", 19, true);
        PersonRedefinition person2 = new PersonRedefinition("Kylin", 18, false);
//        使用改写toString()输出按照我们给定的方式
        System.out.println("---------改写toString（）--------");
        System.out.println(person2.toString());
        System.out.println(person2);

/*//        如果没有重写object的equals方法，默认比较的是对象指向的地址值
        System.out.println("----使用默认的equals比较person和person0（实际上比较的是两者的地址）---");
        System.out.println(person.equals(person0));
        System.out.println(person.toString());
        System.out.println(person0.toString());*/

//        利用重写的equals方法比较两个对象
        System.out.println("-------重写equals()方法进行比较----");
        System.out.println("person == person ?"+person.equals(person));
        System.out.println("person1 == person2 ?"+person1.equals(person2));

    }

}
