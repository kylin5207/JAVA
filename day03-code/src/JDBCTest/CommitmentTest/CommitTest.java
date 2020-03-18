package JDBCTest.CommitmentTest;

import JDBCTest.JDBCUtilsTest.JDBCUtils;
import org.junit.Assert;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 使⽤用Connection对象来管理事务
 *   开启事务:setAutoCommit(boolean autoCommit) :调⽤该方法设置参数为false，即开启事务
 *   在执⾏sql之前开启事务
 *   提交事务:commit()
 *   当所有sql都执行完提交事务
 *   回滚事务:rollback() 在catch中回滚事务
 */

public class CommitTest {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;


        try {
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);
            //zhangsan向lisi转账500元
            String sql1 = "update account set balance = balance - ? where id = ?";
            String sql2 = "update account set balance = balance + ? where id = ?";

            ps1 = conn.prepareStatement(sql1);
            ps2 = conn.prepareStatement(sql2);

            ps1.setDouble(1, 500);
            ps1.setInt(2, 1);

            ps2.setDouble(1, 500);
            ps2.setDouble(2, 2);

            ps1.executeUpdate();

            //手动制造异常
//            Assert.assertEquals(1, 2);

            ps2.executeUpdate();

            conn.commit();

        } catch (Exception e) {
            e.printStackTrace();
            try {
                if(conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        finally {
            JDBCUtils.close(ps1, conn);
            JDBCUtils.close(ps2, null);

        }

    }
}
