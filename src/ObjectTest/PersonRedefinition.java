package ObjectTest;

//PersonRedefinition类继承类Person类，同时重写了toString()方法

public class PersonRedefinition extends Person {
    public PersonRedefinition() {
    }

    public PersonRedefinition(String name, int age, boolean isMale) {
        super(name, age, isMale);
    }

/*    @Override可以不用自己手写
    public String toString() {
        String string = "Person{name = " + name + ", age = " + age + ", isMale = " + isMale +"}";
        return string;
    }*/

    @Override
    public String toString() {
        return "PersonRedefinition{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", isMale=" + isMale +
                '}';
    }
}
