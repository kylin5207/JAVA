package jedis.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * JedisPool的工具类
 *      加载配置文件，配置连接池参数，提供获取连接的方法
 */
public class JedisPoolUtils {
    private static JedisPool jedisPool;

    static {
        // 1. 读取配置文件
        InputStream is = JedisPoolUtils.class.getClassLoader().getResourceAsStream("jedis.properties");
        Properties properties = new Properties();
        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 2. 设置到jedisPoolConfig中
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(Integer.parseInt(properties.getProperty("maxTotal")));
        jedisPoolConfig.setMaxIdle(Integer.parseInt(properties.getProperty("maxIdle")));

        // 3. 初始化JedisPool
        String host = properties.getProperty("host");
        String port = properties.getProperty("port");
        jedisPool = new JedisPool(jedisPoolConfig,host, Integer.parseInt(port));
    }

    public static Jedis getJedis(){
        return jedisPool.getResource();
    }
}
