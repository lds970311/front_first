// Author : evan lee
// Time ： 2022-05-25  0:47
// FILENAME : RedisConfig.java
// STATEMENT: 

package com.hmdp.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedisConfig {
    @Bean
    public RedissonClient redissonClient() {
        //配置类
        Config config = new Config();
        config.useSingleServer()
                .setAddress("redis://192.168.208.129:6379")
                .setPassword("19970311");
        return Redisson.create(config);
    }
}
