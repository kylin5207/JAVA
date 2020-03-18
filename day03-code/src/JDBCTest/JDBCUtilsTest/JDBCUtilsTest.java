package JDBCTest.JDBCUtilsTest;

import JDBCTest.QueryTest.Emp;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JDBCUtilsTest {
    public static void main(String[] args) {
        List<Emp> list = findAll2();
        Iterator<Emp> it = list.iterator();
        while(it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }

    public static List<Emp> findAll2() {
        List<Emp> list = new ArrayList<>();

        Connection conn = null;

        Statement stmt = null;

        ResultSet rs = null;

        try{
           conn = JDBCUtils.getConnection();
           stmt = conn.createStatement();
           String sql = "select * from emp";
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
        catch (SQLException e) {
            e.printStackTrace();
        }
        // 7. 释放资源
        finally {
            JDBCUtils.close(rs, stmt, conn);
        }

        return list;
    }
}
