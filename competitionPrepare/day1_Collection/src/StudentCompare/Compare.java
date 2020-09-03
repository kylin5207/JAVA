package StudentCompare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Compare {
    public static void main(String[] args) {
        ArrayList<Student> studentArrayList = new ArrayList<>();
        studentArrayList.add(new Student("Kylin", 21));
        studentArrayList.add(new Student("Smq", 18));
        studentArrayList.add(new Student("Ysl", 38));

        Collections.sort(studentArrayList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge()-o2.getAge();
            }
        });

        for (Student student : studentArrayList) {
            System.out.println(student);
        }
    }
}
