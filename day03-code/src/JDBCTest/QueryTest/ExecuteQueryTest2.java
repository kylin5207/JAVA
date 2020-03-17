package JDBCTest.QueryTest;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 练习:
 *  定义⼀个方法，查询emp表的数据将其封装为对象，然后装载集合，返回。
 *      1. 定义Emp类
 *      2. 定义⽅法 public List<Emp> findAll(){}
 *      3. 实现方法 select * from emp;
 */

public class ExecuteQueryTest2 {
    public static void main(String[] args) {
        List<Emp> list = findAll();
        Iterator<Emp> it = list.iterator();
        while(it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }

    public static List<Emp> findAll() {
            List<Emp> list = new ArrayList<>();

            Connection conn = null;

            Statement stmt = null;

            ResultSet rs = null;

            try{
                // 1. 注册驱动
                Class.forName("com.mysql.jdbc.Driver");

                // 2. 定义sql
                String sql = "select * from emp";

                // 3. 获取数据库连接对象 Connection
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "123456");

                // 4. 获取执行sql语句的对象 Statement
                stmt = conn.createStatement();

                // 5. 执行sql，接受返回结果
                rs = stmt.executeQuery(sql);

                //  6. 处理结果
                while(rs.next()) {
                    int id = rs.getInt(1);
                    String ename = rs.getString(2);
                    int job_id = rs.getInt(3);
                    int mgr = rs.getInt(4);
                    Date joindate = rs.getDate(5);
                    double salary = rs.getDouble(6);
                    double bonus = rs.getDouble(7);
                    int dept_id = rs.getInt(8);
                    Emp emp = new Emp(id, ename, job_id, mgr, joindate, salary, bonus, dept_id);
                    list.add(emp);
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

            return list;
    }
}
