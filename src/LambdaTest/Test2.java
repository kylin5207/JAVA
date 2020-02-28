package LambdaTest;

/*
    需求:
        使用数组存储多个Person对象,对数组中的Person对象使用Arrays的sort方法通过年龄进行升序排序
 */

import java.util.Arrays;
import java.util.Comparator;

class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class Test2 {
    public static void main(String[] args) {
        Person[] arrays = new Person[3];
        arrays[0] = new Person("Kylin",21);
        arrays[1] = new Person("Smq",18);
        arrays[2] = new Person("Ysl",40);

        System.out.println("--------排序前-----------");

        for (int i = 0; i < arrays.length; i++) {
            System.out.println(arrays[i]);
        }

        Arrays.sort(arrays, new Comparator<Person>() {
            @Override
            public int compare(Person person, Person t1) {
                return person.getAge() - t1.getAge();
            }
        });

        System.out.println("-------排序后-----------");

        for (int i = 0; i < arrays.length; i++) {
            System.out.println(arrays[i]);
        }


        //使用lambda表达式，简化匿名内部类
        Person[] arrays2 = new Person[3];
        arrays2[0] = new Person("Anne",9);
        arrays2[1] = new Person("Smq",3);
        arrays2[2] = new Person("Jully",18);

        System.out.println("-----------排序前-----------");

        for (int i = 0; i < arrays2.length; i++) {
            System.out.println(arrays2[i]);
        }

        Arrays.sort(arrays2,(Person o1, Person o2) -> {return o1.getAge() - o2.getAge();});

        System.out.println("------排序后--------");
        for (Person person : arrays2) {
            System.out.println(person);
        }


    }
}
