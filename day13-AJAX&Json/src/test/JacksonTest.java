package test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Person;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Jackson的使用：
 * 1. 导⼊jackson的相关jar包
 * 2. 创建Jackson核心对象 ObjectMapper
 * 3. 调⽤ObjectMapper的相关⽅法进行转换
 */

public class JacksonTest {

    //Java对象转为json字符串
    @Test
    public void test1() throws IOException {
        //1. 创建Person对象
        Person p = new Person();
        p.setName("帅琦");
        p.setAge(23);
        p.setGender("男");

        Person p2 = new Person();
        p2.setName("丑林");
        p2.setAge(3);
        p2.setGender("男");

        //2. 创建Jackson的核心对象
        ObjectMapper mapper = new ObjectMapper();

        //3. 调用转换方法
        //转换⽅法:
        //3.1 writeValue(参数1，obj):
        //参数:
        // File:将obj对象转换为JSON字符串，并保存到指定的⽂件中
        // Writer:将obj对象转换为JSON字符串，并将json数据填充到字符输出流中
        // OutputStream:将obj对象转换为JSON字符串，并将json数据填充到字节输出流中
        File file = new File("person.txt");
        System.out.println(file.getAbsolutePath());
        mapper.writeValue(file,p);

        mapper.writeValue(new FileWriter("person.txt", true), p2);

        //3.2 writeValueAsString(obj):将对象转为json字符串
        String json = mapper.writeValueAsString(p);
        //{"name":"帅琦", "age":23, "gender":"男"}
        System.out.println(json);
    }

    @Test
    public void test2() throws IOException {
        //1. 创建Person对象
        Person p = new Person();
        p.setName("帅琦");
        p.setAge(23);
        p.setGender("男");
        p.setBirthday(new Date());

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(p);
        System.out.println(json);
    }

    //复杂对象的转换——List
    @Test
    public void test3() throws IOException {
        //复杂对象的转换
        Person p1 = new Person();
        p1.setName("帅琦");
        p1.setAge(23);
        p1.setGender("男");
        p1.setBirthday(new Date());

        Person p2 = new Person();
        p2.setName("丑林");
        p2.setAge(3);
        p2.setGender("男");
        p2.setBirthday(new Date());

        Person p3 = new Person();
        p3.setName("Kylin");
        p3.setAge(8);
        p3.setGender("男");
        p3.setBirthday(new Date());

        // 使用集合存储3个对象
        List<Person> list = new ArrayList<Person>();
        list.add(p1);
        list.add(p2);
        list.add(p3);


        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(list);
        System.out.println(json);
    }

    //复杂对象的转换——Map
    @Test
    public void test4() throws IOException {
        //复杂对象的转换
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "帅琦");
        map.put("age", 13);
        map.put("gender", "男");

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(map);
        System.out.println(json);
    }

}
