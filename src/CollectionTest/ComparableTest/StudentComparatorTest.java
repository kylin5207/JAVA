package CollectionTest.ComparableTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StudentComparatorTest {
    public static void main(String[] args) {

        Student student1 = new Student("Kylin", 97);
        Student student2 = new Student("Ysl", 60);
        Student student3 = new Student("Smq", 100);
        Student student4 = new Student("Jim", 97);

        ArrayList<Student> list = new ArrayList<>();

        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.add(student4);

        System.out.println("默认的顺序为："+list);

        //单纯比较成绩，但是如果成绩相同，则student之间的顺序不一定
//        Collections.sort(list, new Comparator<Student>() {
//            @Override
//            public int compare(Student student, Student t1) {
//                return t1.getGrade() - student.getGrade(); // 按照成绩降序排序
//            }
//        });

        Collections.sort(list, new Comparator<Student>() {
            @Override //如果成绩相同，则按照名字的首字母进行生序比较
            public int compare(Student student, Student t1) {
                int result = t1.getGrade() - student.getGrade();
                if(result == 0){
                    return student.getName().charAt(0) - t1.getName().charAt(0);
                }
                else {
                    return result;
                }
            }
        });

        System.out.println("降序排序后的list："+list);
    }
}
