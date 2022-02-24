// Author : evan lee
// Time ： 2022-02-24  14:58
// FILENAME : CoffeeStore.java
// STATEMENT: 

package com.evanlee.constructor.factorymode.before;

public class CoffeeStore {
    public static AbstractCoffee buyCoffee(String name) {
        AbstractCoffee coffee = null;
        switch (name) {
            case "American":
                coffee = new AmericanCoffee();
                break;
            case "latte":
                coffee = new LatteCoffee();
                break;
            default:
                throw new RuntimeException("no such coffee");
        }

        coffee.addSugar();
        coffee.addMilk();
        return coffee;
    }
}
