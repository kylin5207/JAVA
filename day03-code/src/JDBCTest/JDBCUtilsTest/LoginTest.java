package JDBCTest.JDBCUtilsTest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * 练习:
 * 需求:
 * 1. 通过键盘录⼊用户名和密码
 * 2. 判断⽤户是否登录成功
 *     * select * from user where username = "" and password = ""
 * *    如果这个sql有查询结果，则成功，反之，则失败
 */
public class LoginTest {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String name, password;
        boolean flag;

        System.out.println("请输入账号：");
        name = sc.nextLine();
        System.out.println("请输入密码：");
        password = sc.nextLine();

        flag = login(name, password);

        if(flag) {
            System.out.println("登陆成功");
        }
        else {
            System.out.println("登陆失败");
        }
    }

    /**
     * 登陆方法
     * @param username  用户名
     * @param password  密码
     * @return
     */
    public static boolean login(String username, String password) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        if(username == null || password == null) {
            return false;
        }
        //连接数据库,判断是否登陆成功
        String sql = "select * from USER where username = '" + username + "' and pwd = '" + password + "'";
        try {
            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

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
