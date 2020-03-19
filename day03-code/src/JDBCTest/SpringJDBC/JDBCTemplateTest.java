package JDBCTest.SpringJDBC;

import JDBCTest.DataSource.DRUID.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *Spring框架对JDBC的简单封装。
 * 提供了一个JDBCTemplate对象简化JDBC的开发
 * 步骤:
 * 1. 导⼊jar包
 * 2. 创建JdbcTemplate对象。
 *    依赖于数据源DataSource
 *    JdbcTemplate template = new JdbcTemplate(ds);
 * 3. 调用JdbcTemplate的⽅法来完成CRUD的操作
 *    update():执行DML语句。增、删、改语句
 *    queryForMap():查询结果将结果集封装为map集合，将列名作为key，将值作为value 将这条记录封装为一个map集合
 *         注意:这个方法查询的结果集长度只能是1
 *    queryForList():查询结果将结果集封装为list集合
 *        注意:将每⼀条记录封装为⼀个Map集合，再将Map集合装载到List集合中
 *    query():查询结果，将结果封装为JavaBean对象
 *        query的参数:RowMapper
 *   queryForObject:查询结果，将结果封装为对象
 *        ⼀般用于聚合函数的查询
 */
public class JDBCTemplateTest {
    public static void main(String[] args) {
        //1. 创建JdbcTemplate对象
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

        //2. 定义sql
        String sql = "update account set balance = 5000 where id = ?";

        //3. 调用方法
        int count = template.update(sql,3);
        System.out.println(count);
    }
}
