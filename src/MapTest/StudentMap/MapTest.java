package MapTest.StudentMap;

//利用map存储自定义对象时，一定要重写hashCode()和equals()方法，保证键唯一

import CollectionTest.SetTest.HashCodeTest.Person;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        Map<Student, String> map = new HashMap<>();
        Student student1 = new Student("Kylin", 10);
        Student student2 = new Student("Smq", 18);
        Student student3 = new Student("Ysl", 40);

        map.put(student1, "三门峡");
        map.put(student2, "三门峡");
        map.put(student3, "洛阳");

        //遍历map
        for(Map.Entry<Student, String> entry: map.entrySet()) {
            Student student = entry.getKey();
            String address = entry.getValue();
            System.out.println(student + ", address : " + address);
        }

    }
}
