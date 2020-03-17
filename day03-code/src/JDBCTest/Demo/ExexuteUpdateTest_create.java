package JDBCTest.Demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *  执行DDL语句
 */
public class ExexuteUpdateTest_create {
    public static void main(String[] args) {
        Connection conn = null;

        Statement stmt = null;

        try{
            // 1. 注册驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 2. 定义sql
            String sql = "create table javatest (id int, name varchar(20))";

            // 3. 获取数据库连接对象 Connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "123456");

            // 4. 获取执行sql语句的对象 Statement
            stmt = conn.createStatement();

            // 5. 执行sql，接受返回结果
            int count = stmt.executeUpdate(sql);

            //  6. 处理结果
            System.out.println(count);

        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        // 7. 释放资源
        finally {
            if(stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
