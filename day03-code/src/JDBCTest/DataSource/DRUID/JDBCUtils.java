package JDBCTest.DataSource.DRUID;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Druid连接池工具类JDBCUtils
 * 1. 定义⼀个类 JDBCUtils
 * 2. 提供静态代码块加载配置⽂件，初始化连接池对象
 * 3. 提供方法
 *      1. 获取连接⽅法:通过数据库连接池获取连接
 *      2. 释放资源
 *     3. 获取连接池的⽅法
 */
public class JDBCUtils {
    private static DataSource ds;

    static{
        //1. 加载配置文件
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("/Users/shangmengqi/Desktop/kylin/JAVA学习/day03-code/src/druid.properties"));

            //2. 获取连接池对象
            ds = DruidDataSourceFactory.createDataSource(properties);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

//    1. 获取连接⽅法
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

//    2. 释放资源
    public static void close(Statement stmt, Connection conn) {
        close(null, stmt, conn);
    }

    public static void close(ResultSet rs, Statement stmt, Connection conn) {
        try{
            if(rs != null) {
                rs.close();
            }
            if(stmt != null) {
                stmt.close();
            }
            if(conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    3. 获取连接池的⽅法
    public static DataSource getDataSource() {
        return ds;
    }

}
