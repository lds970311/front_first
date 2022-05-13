// Author : evan lee
// Time ： 2022-05-13  17:21
// FILENAME : JedisPoolTest.java
// STATEMENT: 

package com.evanlee;

import com.evanlee.jedis.JedisPoolUtil;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisPoolTest {
    private static Jedis jedis;

    @BeforeClass
    public static void initPool() {
        jedis = JedisPoolUtil.getJedis();
    }

    @Test
    public void stringTest() {
        jedis.select(1);
        jedis.hset("student:1", "name", "zhangsan");
    }


    @AfterClass
    public static void releasePool() {
        if (null != jedis) {
            jedis.close();
        }
    }
}
