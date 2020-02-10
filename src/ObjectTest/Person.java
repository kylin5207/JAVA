package ObjectTest;

//Person类没有重写toString()方法

public class Person {
    String name;
    int age;
    boolean isMale;

    public Person() {
    }

    public Person(String name, int age, boolean isMale) {
        this.name = name;
        this.age = age;
        this.isMale = isMale;
    }

}
