package JDBCTest.DataSource.C3P0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * C3P0:数据库连接池技术
 * 步骤:
 * 1. 导入jar包 (两个) c3p0-0.9.5.2.jar和mchange-commons-java-0.2.12 .jar ，不要忘记导⼊数据库驱动jar包
 * 2. 定义配置文件:
 *       名称: c3p0.properties 或者 c3p0-config.xml
 *       路径:直接将文件放在src目录下即可。
 * 3. 创建核心对象 数据库连接池对象 ComboPooledDataSource
 * 4. 获取连接: getConnection
 */
public class C3P0Demo1 {
    public static void main(String[] args) throws SQLException {
        //1. 创建数据库连接池对象
        DataSource ds = new ComboPooledDataSource();

        //2. 获取连接对象
        Connection conn = ds.getConnection();

        System.out.println(conn);

        conn.close();
    }
}
