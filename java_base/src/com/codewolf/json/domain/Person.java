// Author : evan lee
// Time ： 2022-01-24  16:17
// FILENAME : Person.java
// STATEMENT: 

package com.codewolf.json.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;

@Data
public class Person {
    private String name;
    @JsonIgnore
    private int age;
    private String gender;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    public Person() {
    }

    public Person(String name, int age, String gender, Date birthday) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.birthday = birthday;
    }
}
