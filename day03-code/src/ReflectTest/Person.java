package ReflectTest;

public class Person {
    private String name;
    private int age;
    public String classID;

    public Person() {
    }

    public Person(String name, int age, String classID) {
        this.name = name;
        this.age = age;
        this.classID = classID;
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

    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", classID='" + classID + '\'' +
                '}';
    }
}
