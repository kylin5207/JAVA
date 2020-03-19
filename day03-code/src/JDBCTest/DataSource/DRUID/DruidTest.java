package JDBCTest.DataSource.DRUID;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileReader;
import java.sql.Connection;
import java.util.Properties;

/**Druid:数据库连接池实现技术，由阿⾥巴巴提供的
 * 1. 导⼊jar包 druid-1.0.9.jar
 * 2. 定义配置⽂件:
 *       1 是properties形式的
 *       2 可以叫任意名称，可以放在任意⽬目录下
 * 3. 加载配置⽂件:Properties
 * 4. 获取数据库连接池对象:通过⼯厂来获取 DruidDataSourceFactory
 * 5. 获取连接:getConnection
 */
public class DruidTest {
    public static void main(String[] args) throws Exception {
        //1. 加载配置文件Properties
        Properties properties = new Properties();
        properties.load(new FileReader("/Users/shangmengqi/Desktop/kylin/JAVA学习/day03-code/src/druid.properties"));

        //2. 获取连接池对象
        DataSource ds = DruidDataSourceFactory.createDataSource(properties);

        //3. 获取连接
        for (int i = 1; i <= 10; i++) {
            Connection conn = ds.getConnection();
            System.out.println(i + " : " + conn);
            conn.close(); //用完归还，之后就可以重复使用
        }

    }
}
