package ClassTest.StudentDemo;

//自定义4个学生对象,添加到集合,并遍历

import java.util.ArrayList;

public class StudentArrayTest {
    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();

        Student stu1 = new Student("Ann", 18, 95);
        Student stu2 = new Student("Bnn", 12, 92);
        Student stu3 = new Student("Cnn", 14, 91);
        Student stu4 = new Student("Dnn", 20, 100);

        students.add(stu1);
        students.add(stu2);
        students.add(stu3);
        students.add(stu4);

        for (int i = 0; i < students.size(); i++) {
            Student stu = students.get(i);
            System.out.println(stu.getName()+", score:" + stu.getScore());
        }
    }
}
