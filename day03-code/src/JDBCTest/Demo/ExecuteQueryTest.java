package JDBCTest.Demo;

import java.sql.*;

/**
 * ResultSet结果集对象：
 * 1) 得到连接对象
 * 2) 得到语句对象
 * 3) 执行SQL语句得到结果集ResultSet对象 4) 循环遍历取出每一条记录
 * 5) 输出的控制台上
 * 6) 释放资源
 */
public class ExecuteQueryTest {
    public static void main(String[] args) {
        Connection conn = null;

        Statement stmt = null;

        ResultSet rs = null;

        try{
            // 1. 注册驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 2. 定义sql
            String sql = "select * from account";

            // 3. 获取数据库连接对象 Connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "123456");

            // 4. 获取执行sql语句的对象 Statement
            stmt = conn.createStatement();

            // 5. 执行sql，接受返回结果
            rs = stmt.executeQuery(sql);

            //  6. 处理结果
            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Double salary = rs.getDouble(3);
                System.out.println("id = " + id + ", name = "+name + ", salary = " + salary);
            }

        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        // 7. 释放资源
        finally {
            if(rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

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
