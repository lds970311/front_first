// Author : evan lee
// Time ： 2022-02-24  14:55
// FILENAME : AbstractCoffee.java
// STATEMENT: 

package com.evanlee.construct.factorymode.before;

public abstract class AbstractCoffee {
    public abstract String getName();

    public void addSugar() {
        System.out.println("add sugar");
    }

    public void addMilk() {
        System.out.println("add milk");
    }
}
