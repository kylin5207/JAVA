package JDBCTest.JDBCUtilsTest;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * JDBC工具类:
 * 1. 注册驱动也抽取
 * 2. 抽取一个方法获取连接对象
 *      需求:不想传递参数(麻烦)，还得保证工具类的通用性。
 *       解决:配置文件
 *              jdbc.properties
 *                  url=
 *                  user=
 *                  password=
 * 3. 抽取⼀个方法释放资源
 */
public class JDBCUtils {

    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    /*
        ⽂件的读取，只需要读取一次即可拿到这些值。使用静态代码块
     */
    static {
        //读取资源文件，获取值
        //注意：静态方法只能处理异常，不能抛出异常
        try{
            Properties properties = new Properties();
            //可以使用绝对路径，但是这种方法不好
             properties.load(new FileReader("/Users/shangmengqi/Desktop/kylin/JAVA学习/day03-code/src/JDBCTest/jdbc.properties"));

            //获取src路径下文件的方式(这个怪我，我的文件名用了中文符号，所以有些问题)
//            URL res = JDBCUtils.class.getClassLoader().getResource("JDBCTest/jdbc.properties");
//
//            String path = res.getPath();
//            System.out.println(path);
//            properties.load(new FileReader(path));

            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            driver = properties.getProperty("Driver");

            Class.forName(driver);
        }
        catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
    /**
     * 获取数据库连接对象Connection的方法
     * @return Connection对象
     */
    public static Connection getConnection() throws SQLException {
        return   DriverManager.getConnection(url, user, password);
    }



    /**
     * 释放资源
     */
    public static void close(Statement stmt, Connection conn) {
        if(stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(conn != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public static void close(ResultSet rs, Statement stmt, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
