// Author : evan lee
// Time ： 2022-02-20  18:25
// FILENAME : OptionalAPIs.java
// STATEMENT: 

package com.codewolf.newfeature.jdk8;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
class Teacher {
    private String name;
    private Double salary;
    private String nickName;

    public Teacher(String name, Double salary) {
        this.name = name;
        this.salary = salary;
    }
}

public class OptionalAPIs {


    public static void main(String[] args) {
        Teacher teacher = null;
        Teacher teacher1 = Optional.ofNullable(teacher)
                .orElse(createTeacher());

    }

    private static Teacher createTeacher() {
        return new Teacher("lisa", 9999.0);
    }
}
