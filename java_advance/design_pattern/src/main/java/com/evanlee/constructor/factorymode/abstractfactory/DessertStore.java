// Author : evan lee
// Time ： 2022-02-24  16:36
// FILENAME : DessertStore.java
// STATEMENT: 

package com.evanlee.constructor.factorymode.abstractfactory;

public class DessertStore {
    private final DessertFactory dessertFactory;

    public DessertStore(DessertFactory dessertFactory) {
        this.dessertFactory = dessertFactory;
    }

    public void orderDessert() {
        Dessert dessert = dessertFactory.createDessert();
        dessert.show();
        AbstractCoffee coffee = dessertFactory.createCoffee();
        coffee.addSugar();
        coffee.addMilk();
        System.out.println(coffee.getName());
    }
}
