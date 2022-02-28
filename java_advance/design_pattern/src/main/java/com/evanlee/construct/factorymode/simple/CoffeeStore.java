package com.evanlee.construct.factorymode.simple;


public class CoffeeStore {
    public static AbstractCoffee buyCoffee(String name) {
        AbstractCoffee coffee = SimpleCoffeeFactory.createCoffee(name);
        coffee.addMilk();
        coffee.addSugar();
        return coffee;
    }
}
