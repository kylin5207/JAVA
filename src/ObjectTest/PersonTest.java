package ObjectTest;

public class PersonTest {
    public static void main(String[] args) {

        Person person = new Person();

//        使用默认的toString，即object类的toString()和直接print(对象名的效果一样)
//        输出值：对象类名@地址
        System.out.println("--------默认toString（）--------");
        System.out.println(person.toString());
        System.out.println(person);

        PersonRedefinition person2 = new PersonRedefinition("Kylin", 18, false);
//        使用改写toString()输出按照我们给定的方式
        System.out.println("---------改写toString（）--------");
        System.out.println(person2.toString());
        System.out.println(person2);

    }

}
