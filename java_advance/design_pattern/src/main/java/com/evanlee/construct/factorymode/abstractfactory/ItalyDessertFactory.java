// Author : evan lee
// Time ： 2022-02-24  16:33
// FILENAME : ItalyDessertFactory.java
// STATEMENT: 

package com.evanlee.construct.factorymode.abstractfactory;

public class ItalyDessertFactory implements DessertFactory {

    @Override
    public AbstractCoffee createCoffee() {
        return new LatteCoffee();
    }

    @Override
    public Dessert createDessert() {
        return new Trimisu();
    }
}
