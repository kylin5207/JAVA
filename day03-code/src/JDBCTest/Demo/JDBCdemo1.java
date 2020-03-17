package JDBCTest.Demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *  JDBC快速入门：
 *      1. 导⼊驱动jar包 mysql-connector-java-5.1.37-bin.jar
 *          1.复制mysql-connector-java-5.1.37-bin.jar到项⽬的libs⽬录下
 *          2.右键-->Add As Library
 *      2. 注册驱动
 *      3. 获取数据库连接对象 Connection
 *      4. 定义sql
 *      5. 获取执行sql语句的对象 Statement
 *      6. 执行sql，接受返回结果
 *      7. 处理结果
 *      8. 释放资源
 */

public class JDBCdemo1 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        1. 注册驱动
        /*
            通过查看源码发现:在com.mysql.jdbc.Driver类中存在静态代码块
         */
        Class.forName("com.mysql.jdbc.Driver");

//        2. 获取数据库连接对象 Connection
        /*
            指定路径url，用户名user，密码password
         */
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "123456");

//        3. 定义sql
        String sql = "update account set balance = 1500 where id = 1";

//        4. 获取执行sql语句的对象 Statement
        Statement stmt = conn.createStatement();

//        5. 执行sql，接受返回结果
        int count = stmt.executeUpdate(sql);

//        6. 处理结果
        System.out.println(count);

//        7. 释放资源
        stmt.close();
        conn.close();
    }
}
