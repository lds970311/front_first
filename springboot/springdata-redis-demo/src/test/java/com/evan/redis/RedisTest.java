// Author : evan lee
// Time ： 2022-05-13  18:25
// FILENAME : RedisTest.java
// STATEMENT: 

package com.evan.redis;

import com.evan.redis.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
public class RedisTest {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void stringTest() {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set("name", "lisi");
        String name = (String) valueOperations.get("name");
        System.out.println(name);
    }

    @Test
    void saveStudent() {
        Student student = new Student(1, "evan", "ONE", 21);
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set("student:1", student);
    }
}
