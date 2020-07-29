package mybatis.utils;

import mybatis.sqlSession.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 用于创建数据源的工具类
 */
public class DataSourceUtil {
    public static Connection getConnection(Configuration config){
        Connection conn = null;
        try{
            Class.forName(config.getDriver());
            conn = DriverManager.getConnection(config.getUrl(), config.getUsername(), config.getPassword());
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
        return conn;
    }
}
