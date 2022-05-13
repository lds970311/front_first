// Author : evan lee
// Time ： 2022-05-13  19:22
// FILENAME : StringRedisTemplateTest.java
// STATEMENT: 

package com.evan.redis;

import com.evan.redis.pojo.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;
import java.util.Map;

@SpringBootTest
public class StringRedisTemplateTest {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    //JSON工具
    private static final ObjectMapper mapper = new ObjectMapper();

    @Test
    void stringTest() throws JsonProcessingException {
        Student student = new Student(2, "sam", "two", 33);
        //手动序列化
        String s = mapper.writeValueAsString(student);
        ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
        valueOperations.set("student:2", s);
        String s1 = valueOperations.get("student:2");
        Student student1 = mapper.readValue(s1, Student.class);
        System.out.println(student1);
    }

    @Test
    void hashTest() {
        HashOperations<String, Object, Object> stringObjectObjectHashOperations = stringRedisTemplate.opsForHash();
        stringObjectObjectHashOperations.put("student:3", "time", "2022");
        Map<Object, Object> entries = stringObjectObjectHashOperations.entries("student:3");
        entries.forEach((k, v) -> {
            System.out.println(k);
            System.out.println(v);
        });
    }
}
