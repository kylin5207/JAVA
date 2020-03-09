package FunctionalInterface.MethodQuote.ConstructionQuote;

/*
    构造器引用:
        类名称::new

 */
public class ConstructionQuote {
    public static void main(String[] args) {
        String name = "Kylin";

//        使用lambda表达式
//        printName(name, name2->new Person(name2));

//        使用构造方法的方法引用
        printName(name, Person::new);

    }

    public static void printName(String name, PersonBuilder pb) {
        Person person = pb.createPerson(name);
        System.out.println(person.getName());
    }

}
