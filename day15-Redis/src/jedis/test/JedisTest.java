package jedis.test;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Jedis测试类
 */

public class JedisTest {
    /**
     * 快速入门
     */
    @Test
    public void test1(){
        //1. 获取连接
        Jedis jedis = new Jedis("localhost", 6379);

        //2. 操作
        jedis.set("username", "shuaiqi");

        //3. 关闭连接
        jedis.close();
    }

    /**
     * String 数据结构操作
     */
    @Test
    public void test2(){
        //1. 获取连接
        //如果使用空参构造，则默认值是localhost和6379端口
        Jedis jedis = new Jedis("localhost", 6379);

        //2. 操作
        jedis.set("pet", "buting");
        //获取
        String pet = jedis.get("pet");
        System.out.println(pet);

        //可使用setex()存储可以指定过期时间的key和value
        jedis.setex("activecode", 20, "hehe");
        //将key和value键值对存入redis，并且20秒后自动删除

        //3. 关闭连接
        jedis.close();
    }

    /**
     * Hash 数据结构操作
     */
    @Test
    public void test3(){
        //1. 获取连接
        //如果使用空参构造，则默认值是localhost和6379端口
        Jedis jedis = new Jedis("localhost", 6379);

        //2. 操作
        jedis.hset("user", "name", "kylin");
        jedis.hset("user", "gender", "male");
        jedis.hset("user", "address", "luoyang");

        //获取
        String name = jedis.hget("user", "name");
        System.out.println(name);

        //获取所有数据
        Map<String, String> map =  jedis.hgetAll("user");
        //利用keySet
        Set<String> keyset = map.keySet();
        for (String key : keyset) {
            String value = map.get(key);
            System.out.println(key + " : " + value);
        }

        //3. 关闭连接
        jedis.close();
    }

    /**
     * List 数据结构操作
     */
    @Test
    public void test4(){
        //1. 获取连接
        //如果使用空参构造，则默认值是localhost和6379端口
        Jedis jedis = new Jedis("localhost", 6379);

        //2. 操作
        jedis.lpush("mylist", "a", "b", "c");
        jedis.rpush("mylist", "1", "2", "3");

        //list范围获取
        List<String> mylist = jedis.lrange("mylist", 0, -1);
        System.out.println(mylist);

        //list弹出
        String element = jedis.lpop("mylist");
        System.out.println(element);

        String element2 = jedis.rpop("mylist");
        System.out.println(element2);

        //3. 关闭连接
        jedis.close();
    }

    /**
     * Set 数据结构操作
     */
    @Test
    public void test5(){
        //1. 获取连接
        //如果使用空参构造，则默认值是localhost和6379端口
        Jedis jedis = new Jedis("localhost", 6379);

        //2. 操作
        jedis.sadd("mySet", "java", "python", "c");
        Set<String> set = jedis.smembers("mySet");
        System.out.println(set);
        //3. 关闭连接
        jedis.close();
    }

    /**
     * SortedSet 数据结构操作
     */
    @Test
    public void test6(){
        //1. 获取连接
        //如果使用空参构造，则默认值是localhost和6379端口
        Jedis jedis = new Jedis("localhost", 6379);

        //2. 操作
        jedis.zadd("mySortedSet", 100, "kylin");
        jedis.zadd("mySortedSet", 70, "Smq");
        jedis.zadd("mySortedSet", 60, "Ysl");

        Set<String> set = jedis.zrange("mySortedSet", 0, -1);
        System.out.println(set);

        //3. 关闭连接
        jedis.close();
    }
}
