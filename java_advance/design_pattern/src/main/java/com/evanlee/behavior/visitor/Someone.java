// Author : evan lee
// Time ： 2022-03-14  20:50
// FILENAME : Someone.java
// STATEMENT: 

package com.evanlee.behavior.visitor;

public class Someone implements Person {
    @Override
    public void feed(Cat cat) {
        System.out.println("其他人喂食猫");
    }

    @Override
    public void feed(Dog dog) {
        System.out.println("其他人喂食狗");
    }
}
