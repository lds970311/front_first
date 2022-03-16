// Author : evan lee
// Time ： 2022-03-14  20:51
// FILENAME : Dog.java
// STATEMENT: 

package com.evanlee.behavior.visitor;

public class Dog implements Animal {

    @Override
    public void accept(Person person) {
        person.feed(this);
        System.out.println("好好吃，汪汪汪！！！");
    }
}
