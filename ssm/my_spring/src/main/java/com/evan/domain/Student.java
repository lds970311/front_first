// AUTHOR: CSR丶SUSE
// TIME : 2022-01-31  23:50
// FILENAME: Student.java
// TOOLS : INTELLIJ IDEA
// STATEMENT: 使用构造哈数注入属性


package com.evan.domain;

public class Student {

    private String name;
    private Integer age;

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
