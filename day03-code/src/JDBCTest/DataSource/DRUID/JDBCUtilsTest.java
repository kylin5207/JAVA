package JDBCTest.DataSource.DRUID;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * druidJDBCUtils测试
 * 给account表添加一条新记录
 */

public class JDBCUtilsTest {
    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            //1. 获取连接
           conn = JDBCUtils.getConnection();

           //2. 定义sql语句
           String sql = "insert into account values(null, ?, ?)";

           //3. 获取执行sql的对象pstmt
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "Kylin");
            pstmt.setDouble(2, 1999);

            //4. 执行sql语句
            int count = pstmt.executeUpdate();

            System.out.println(count);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            JDBCUtils.close(pstmt, conn);
        }

    }
}
