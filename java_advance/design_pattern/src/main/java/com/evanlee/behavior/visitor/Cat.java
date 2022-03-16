// Author : evan lee
// Time ： 2022-03-14  20:51
// FILENAME : Cat.java
// STATEMENT: 

package com.evanlee.behavior.visitor;

public class Cat implements Animal {

    @Override
    public void accept(Person person) {
        person.feed(this);
        System.out.println("好好吃，喵喵喵！！！");
    }
}
