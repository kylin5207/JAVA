package JDBCTest;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Properties;
import java.util.Set;

public class PropertyTest {
    public static void main(String[] args) {
        Properties properties = new Properties();

        properties.setProperty("url", "jdbc:mysql://localhost:3306/db1");
        properties.setProperty("user", "root");
        properties.setProperty("password", "123456");
        properties.setProperty("Driver", "com.mysql.jdbc.Driver");

        Set<String> properties_set = properties.stringPropertyNames();
        for (String s : properties_set) {
            String value = properties.getProperty(s);
            System.out.println(s + " = " + value);
        }

        try (PrintStream ps = new PrintStream("/Users/shangmengqi/Desktop/kylin/JAVA学习/day03-code/src/JDBCTest/jdbc.properties"))
        {
            for (String s : properties_set) {
                String value = properties.getProperty(s);
                ps.println(s + "=" + value);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
