// Author : evan lee
// Time ： 2022-01-09  16:34
// FILENAME : TestCls.java
// STATEMENT: 

package com.codewolf.java.reflect;

public class TestCls {
    private String name;
    private Integer age;

    public TestCls() {
    }

    public TestCls(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public void showMsg() {
        System.out.println("name=" + this.name + ", age=" + this.age);
    }
}
