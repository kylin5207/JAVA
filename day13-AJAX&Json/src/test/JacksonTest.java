package test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Person;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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

}
