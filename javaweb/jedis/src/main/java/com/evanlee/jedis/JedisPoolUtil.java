// Author : evan lee
// Time ： 2022-01-27  18:55
// FILENAME : JedisPoolUtil.java
// STATEMENT: 

package com.evanlee.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolUtil {
    private static volatile JedisPool jedisPool = null;

    private JedisPoolUtil() {
    }

    public static JedisPool getJedisPoolInstance() {
        if (null == jedisPool) {
            synchronized (JedisPoolUtil.class) {
                if (null == jedisPool) {
                    JedisPoolConfig poolConfig = new JedisPoolConfig();
                    poolConfig.setMaxTotal(200); //最大连接数
                    poolConfig.setMaxIdle(32); //最大空闲连接
                    poolConfig.setMinIdle(0); //最小空闲连接
                    poolConfig.setMaxWaitMillis(100 * 1000); //最大等待时间(ms)
                    poolConfig.setBlockWhenExhausted(true);
                    poolConfig.setTestOnBorrow(true);  // ping  PONG

                    jedisPool = new JedisPool(poolConfig, "192.168.208.129", 6379, 60000, "19970311");
                }
            }
        }
        return jedisPool;
    }

    public static Jedis getJedis() {
        return getJedisPoolInstance().getResource();
    }

    public static void release(JedisPool jedisPool, Jedis jedis) {
        if (null != jedis) {
            jedisPool.close();
        }
    }
}
