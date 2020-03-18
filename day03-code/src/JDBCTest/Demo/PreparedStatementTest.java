package JDBCTest.Demo;

import JDBCTest.JDBCUtilsTest.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * 使用 PreparedStatement 的步骤:
 * 编写 SQL 语句，未知内容使用?占位:"SELECT * FROM user WHERE name=? AND password=?";
 * 获得 PreparedStatement 对象
 * 设置实际参数:setXxx(占位符的位置, 真实的值)
 * 执行参数化 SQL 语句 executeQuery()
 * 关闭资源
 */
public class PreparedStatementTest {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String name, password;
        boolean flag;

        System.out.println("请输入账号：");
        name = sc.nextLine();
        System.out.println("请输入密码：");
        password = sc.nextLine();

        flag = login2(name, password);

        if(flag) {
            System.out.println("登陆成功");
        }
        else {
            System.out.println("登陆失败");
        }
    }

    public static boolean login2(String username, String password) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        if(username == null || password == null) {
            return false;
        }
        //连接数据库,判断是否登陆成功
        String sql = "select * from USER where username = ?  and pwd = ?";
        try {
            //连接数据库
            conn = JDBCUtils.getConnection();

            //获取执行sql的对象
            stmt = conn.prepareStatement(sql);

            //为通配符？赋值
            stmt.setString(1, username);
            stmt.setString(2, password);

            //执行sql语句
            rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            JDBCUtils.close(rs, stmt, conn);
        }
        return false;
    }
}
