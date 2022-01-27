// Author : evan lee
// Time ： 2022-01-26  17:35
// FILENAME : JedisDataTypeTest.java
// STATEMENT: 

package com.evanlee;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JedisDataTypeTest {
    private static Jedis jedis = null;

    static {
        jedis = new Jedis("192.168.208.146", 6379);
        jedis.auth("123456");
    }

    @Test
    public void keyTest() {
        jedis.select(0);
        jedis.flushDB();
        jedis.set("k1", "v1");
        jedis.set("k2", "v2");
        jedis.set("k3", "v3");
        Set<String> keys = jedis.keys("*");
        System.out.println(keys.size());
        for (String key : keys) {
            System.out.println(key);
        }
        System.out.println(jedis.exists("k1"));
        System.out.println(jedis.ttl("k1"));

    }

    @Test
    public void StringTest() {
        jedis.mset("str1", "v1", "str2", "v2", "str3", "v3");
        System.out.println(jedis.mget("str1", "str2", "str3"));
    }

    @Test
    public void listTest() {
        jedis.lpush("mylist", "a", "b", "c", "d", "e", "f", "g", "h");
        System.out.println("len=" + jedis.llen("mylist"));
        List<String> list = jedis.lrange("mylist", 0, 6);
        for (String element : list) {
            System.out.println(element);
        }
    }

    @Test
    public void setTest() {
        jedis.sadd("myset", "one", "two", "three", "four", "five", "six", "seven", "one");
        System.out.println(jedis.scard("myset"));
        Set<String> smembers = jedis.smembers("myset");
        for (String smember : smembers) {
            System.out.println(smember);
        }
    }

    @Test
    public void hashTest() {
        jedis.hset("hash1", "userName", "lisi");
        System.out.println(jedis.hget("hash1", "userName"));
        Map<String, String> map = new HashMap<>();
        map.put("telphone", "13810169999");
        map.put("address", "atguigu");
        map.put("email", "abc@163.com");
        jedis.hmset("hash2", map);
        List<String> result = jedis.hmget("hash2", "telphone", "email");
        for (String element : result) {
            System.out.println(element);
        }
        jedis.del("hash2");
    }

    @Test
    public void zsetTest() {
        jedis.zadd("zset01", 100d, "z3");
        jedis.zadd("zset01", 90d, "l4");
        jedis.zadd("zset01", 80d, "w5");
        jedis.zadd("zset01", 70d, "z6");
        Set<String> zrange = jedis.zrange("zset01", 0, -1);
        zrange.forEach(System.out::println);
        /*
          z6
          w5
          l4
          z3
         */
    }
}
