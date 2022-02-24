// Author : evan lee
// Time ： 2022-02-24  15:37
// FILENAME : LatteCoffeeFactory.java
// STATEMENT: 

package com.evanlee.constructor.factorymode.abstractfactory;

public class LatteCoffeeFactory implements CoffeeFactory {

    @Override
    public AbstractCoffee createCoffee() {
        return new LatteCoffee();
    }
}
