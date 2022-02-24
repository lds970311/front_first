// Author : evan lee
// Time ： 2022-02-24  16:31
// FILENAME : DessertFactory.java
// STATEMENT: 

package com.evanlee.constructor.factorymode.abstractfactory;

public interface DessertFactory {
    //生产咖啡的功能
    AbstractCoffee createCoffee();

    //生产甜品的功能
    Dessert createDessert();
}
