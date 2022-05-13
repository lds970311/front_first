// Author : evan lee
// Time ： 2022-01-26  17:19
// FILENAME : JedisFirst.java
// STATEMENT: 

package com.evanlee.jedis;

import redis.clients.jedis.Jedis;

public class JedisFirst {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.208.129", 6379);
        jedis.auth("19970311");
        String val = jedis.ping();
        System.out.println(val);
    }
}
