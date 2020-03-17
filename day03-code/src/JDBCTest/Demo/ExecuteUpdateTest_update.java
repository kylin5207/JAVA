package JDBCTest.Demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * executeUpdate练习：
 *      account表 修改记录
 */

public class ExecuteUpdateTest_update {
    public static void main(String[] args) {
        Connection conn = null;

        Statement stmt = null;

        try{
            // 1. 注册驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 2. 定义sql
            String sql = "update account set balance = 1000 where id = 3";

            // 3. 获取数据库连接对象 Connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "123456");

            // 4. 获取执行sql语句的对象 Statement
            stmt = conn.createStatement();

            // 5. 执行sql，接受返回结果
            int count = stmt.executeUpdate(sql);

            //  6. 处理结果
            if(count == 1) {
                System.out.println("update操作成功");
            }
            else {
                System.out.println("update操作失败");
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
