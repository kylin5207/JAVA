package JDBCTest.SpringJDBC;

import JDBCTest.DataSource.DRUID.JDBCUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 需求:
 * 1. 修改1号数据的 salary 为 10000
 * 2. 添加一条记录
 * 3. 删除刚才添加的记录
 * 4. 查询id为1的记录，将其封装为Map集合
 * 5. 查询所有记录，将其封装为List
 * 6. 查询所有记录，将其封装为Emp对象的List集合
 * 7. 查询总记录数
 *
 *       update():执行DML语句。增、删、改语句
 *       queryForMap():查询结果将结果集封装为map集合，将列名作为key，将值作为value 将这条记录封装为⼀个map集合
 *           注意:这个方法查询的结果集长度只能是1
 *       queryForList():查询结果将结果集封装为list集合
 *          注意:将每⼀条记录封装为⼀个Map集合，再将Map集合装载到List集合中
 *       query():查询结果，将结果封装为JavaBean对象
 *               query的参数:RowMapper
 *                  一般我们使用BeanPropertyRowMapper实现类。可以完成数据到JavaBean的自动封装
 *                  new BeanPropertyRowMapper<类型>(类型.class)
 *       queryForObject:查询结果，将结果封装为对象
 *          ⼀般用于聚合函数的查询
 */

public class JDBCTemplateTest2 {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Test
    public void test1(){
        System.out.println("执行需求：修改1001号数据的 salary 为 10000");

        String sql = "update emp set salary = 10000 where id = ?";

        int count = template.update(sql,1001);

        Assert.assertEquals(count,1);
    }

    @Test
    public void test2(){
        System.out.println("执行需求：添加一条记录");

        //2. 定义sql
        String sql = "insert into emp(id, ename, dept_id) values(?,?,?) ";

        //3. 调用方法
        int count = template.update(sql,1015, "Kylin", 10);

        Assert.assertEquals(count,1);

    }

    @Test
    public void test3(){
        System.out.println("执行需求：删除id=1015的记录");

        //2. 定义sql
        String sql = "delete from emp where id = ?";

        //3. 调用方法
        int count = template.update(sql,1015);

        Assert.assertEquals(count,1);

    }

    @Test
    public void test4(){
        System.out.println("执行需求：查询id为1001的记录，将其封装为Map集合");

        //2. 定义sql
        String sql = "select * from emp where id = ?";

        //3. 调用方法
        Map<String, Object> map = template.queryForMap(sql, 1001);

        Set<Map.Entry<String, Object>> entryset = map.entrySet();

        for (Map.Entry<String, Object> stringObjectEntry : entryset) {
            System.out.println(stringObjectEntry.getKey() + " = " +stringObjectEntry.getValue());
        }
    }

    @Test
    public void test5() {
        System.out.println("执行需求：查询所有记录，将其封装为Emp对象的List集合");

        //2. 定义sql
        String sql = "select * from emp";

        //3. 调用方法
        List<Map<String, Object>> maplist = template.queryForList(sql);

        for (Map<String, Object> stringObjectMap : maplist) {
            Set<Map.Entry<String, Object>> entryset = stringObjectMap.entrySet();

            for (Map.Entry<String, Object> stringObjectEntry : entryset) {
                System.out.println(stringObjectEntry.getKey() + " = " + stringObjectEntry.getValue());
            }
            System.out.println("-----------");
        }

    }

    @Test
    public void test6() {
        System.out.println("执行需求：查询所有记录，将其封装为Emp对象的List集合");

        //2. 定义sql
        String sql = "select * from emp";

        //3. 调用方法
         List<Emp> list = template.query(sql, new BeanPropertyRowMapper<Emp>(Emp.class));

        for (Emp emp : list) {
            System.out.println(emp);
        }

    }

    @Test
    public void test7() {
        System.out.println("执行需求：查询总记录数");

        //2. 定义sql
        String sql = "select count(id) from emp";

        //3. 调用方法
        Long total = template.queryForObject(sql, Long.class);

        System.out.println("总记录：" + total + "条");

    }


}
