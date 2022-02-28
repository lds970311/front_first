// Author : evan lee
// Time ： 2022-02-24  15:38
// FILENAME : AmericanCoffeeFactory.java
// STATEMENT: 

package com.evanlee.construct.factorymode.abstractfactory;

public class AmericanCoffeeFactory implements CoffeeFactory {

    @Override
    public AbstractCoffee createCoffee() {
        return new AmericanCoffee();
    }
}
