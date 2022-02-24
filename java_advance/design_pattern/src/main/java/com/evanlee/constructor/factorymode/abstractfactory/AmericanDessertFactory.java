// Author : evan lee
// Time ： 2022-02-24  16:32
// FILENAME : AmericanDessertFactory.java
// STATEMENT: 

package com.evanlee.constructor.factorymode.abstractfactory;

public class AmericanDessertFactory implements DessertFactory {

    @Override
    public AbstractCoffee createCoffee() {
        return new AmericanCoffee();
    }

    @Override
    public Dessert createDessert() {
        return new MatchaMousse();
    }
}
