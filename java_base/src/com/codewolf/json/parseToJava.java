// Author : evan lee
// Time ： 2022-01-24  16:15
// FILENAME : parseToJava.java
// STATEMENT: json -> java

package com.codewolf.json;

import com.codewolf.json.domain.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;

public class parseToJava {
    @SneakyThrows
    @Test
    public void jacksonTest() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = simpleDateFormat.parse("1997-03-12");
        //java -> json
        Person person = new Person("zs", 21, "男", date);
        ObjectMapper mapper = new ObjectMapper();
        //转换
        String s = mapper.writeValueAsString(person); //json写入到文件
        mapper.writeValue(new File("F:\\Java\\front_first\\java_base\\logs\\json_result.txt"), person);
        System.out.println(s); //{"name":"zs","age":21,"gender":"男"}
    }

    @Test
    @SneakyThrows
    public void java2json() {
        BufferedReader reader = new BufferedReader(new FileReader("F:\\Java\\front_first\\java_base\\logs\\json_result.txt"));
        String line = reader.readLine();
        ObjectMapper mapper = new ObjectMapper();
        Person person = mapper.readValue(line, Person.class);
        System.out.println(person);
        reader.close();
    }
}
