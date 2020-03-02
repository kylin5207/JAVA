package MapTest;

/*
    属性集：
    唯一和IO流相关的集合，键值都是字符串类型

    public Object setProperty(String key, String value) : 保存一对属性。
    public String getProperty(String key) :使用此属性列表中指定的键搜索属性值。
    public Set<String> stringPropertyNames() :所有键的名称的集合

    store(OutputStream ops/Writer writer, String comments):
         注意：OutputStream字节流，无法写中文；Writer字符流，可以写中文。
              comments注释：不能写中文，默认为Unicode编码，一般使用空字符串

    public void load(InputStream in/Reader reader):
        从输入流中读取属性集

 */
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class PropertiesTest {
    public static void main(String[] args) {
        Properties properties = new Properties();

        //添加属性及值
        properties.setProperty("轨道长半轴", "600");
        properties.setProperty("轨道偏心率", "60.3");
        properties.setProperty("轨道平面倾角", "20.4");

        //遍历属性集
        Set<String> property_set = properties.stringPropertyNames();
        for (String s : property_set) {
            double value = Double.parseDouble(properties.getProperty(s));
            System.out.println(s + " : " + value);
        }

        //使用store()方法
        try(FileWriter fileWriter = new FileWriter("/Users/shangmengqi/Desktop/kylin/JAVA学习/day01-code/src/MapTest/property.txt")){
            properties.store(fileWriter, "save properties");
        }
        catch (IOException e){
            e.printStackTrace();
        }

        //使用load()方法
        try(FileReader fr = new FileReader("/Users/shangmengqi/Desktop/kylin/JAVA学习/day01-code/src/MapTest/Heights.txt")){
            properties.load(fr);
        }
        catch (IOException e){
            e.printStackTrace();
        }


        //遍历属性集
        Set<String> property_set2 = properties.stringPropertyNames();
        for (String s : property_set2) {
            double value = Double.parseDouble(properties.getProperty(s));
            System.out.println(s + " : " + value);
        }

    }
}
