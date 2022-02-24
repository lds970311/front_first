// Author : evan lee
// Time ： 2022-02-24  15:15
// FILENAME : SimpleCoffeeFactory.java
// STATEMENT: 简单工厂类

package com.evanlee.constructor.factorymode.simple;


public class SimpleCoffeeFactory {

    public static AbstractCoffee createCoffee(String type) {
        AbstractCoffee coffee = null;
        switch (type) {
            case "American":
                coffee = new AmericanCoffee();
                break;
            case "latte":
                coffee = new LatteCoffee();
                break;
            default:
                throw new RuntimeException("no such coffee");
        }
        return coffee;
    }
}
