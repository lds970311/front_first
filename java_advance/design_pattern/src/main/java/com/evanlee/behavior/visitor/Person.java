// Author : evan lee
// Time ： 2022-03-14  20:49
// FILENAME : Person.java
// STATEMENT: 

package com.evanlee.behavior.visitor;

//创建抽象访问者接口
public interface Person {
    void feed(Cat cat);

    void feed(Dog dog);
}
