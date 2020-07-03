package jedis.test;

import jedis.util.JedisPoolUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolTest {
    /**
     * jedis连接池对象
     */
    @Test
    public void testJedisPool(){
        //创建一个配置对象
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(5);
        config.setMaxIdle(10);

//        1. 创建JedisPool连接池对象
        JedisPool jedisPool = new JedisPool(config, "localhost", 6379);

        //2. 调用getResource()方法获取Jedis连接
        Jedis jedis = jedisPool.getResource();

        //3. 使用
        jedis.set("time", "2020-7-3");

        //4. 关闭，归还到连接池中
        jedis.close();
    }

    /**
     * jedis连接池对象工具类
     */
    @Test
    public void testJedisPoolUtils(){
        Jedis jedis = JedisPoolUtils.getJedis();

        //3. 使用
        jedis.set("time", "2020-7-4");

        //4. 关闭，归还到连接池中
        jedis.close();
    }
}
