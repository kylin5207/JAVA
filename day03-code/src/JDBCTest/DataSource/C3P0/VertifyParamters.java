package JDBCTest.DataSource.C3P0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 验证c3p0-config.xml文件中设置连接池的其他参数
 */

public class VertifyParamters {
    public static void main(String[] args) throws SQLException {
        //1. 获取DataSource
        //参数为空，则使用默认配置
        DataSource ds = new ComboPooledDataSource();

        //使用给定参数名的配置
//        DataSource ds = new ComboPooledDataSource("otherc3p0");

        //2. 获取连接
        //对最大连接数maxPoolSize进行验证，目前这个值是10
        for (int i = 1; i <= 10; i++) {
            Connection conn = ds.getConnection();
            System.out.println(i + " : " + conn);
            conn.close(); //用完归还，之后就可以重复使用
        }

        //等待3秒会报错（归还后，就可以重新使用）
        Connection conn = ds.getConnection();
        System.out.println(11 + " : " + conn);
    }
}
