package com.evanlee.constructor.factorymode.abstractfactory;


public class CoffeeStore {
    private final CoffeeFactory coffeeFactory;

    public CoffeeStore(CoffeeFactory coffeeFactory) {
        this.coffeeFactory = coffeeFactory;
    }

    public AbstractCoffee buyCoffee() {
        AbstractCoffee coffee = coffeeFactory.createCoffee();
        coffee.addMilk();
        coffee.addSugar();
        return coffee;
    }
}
