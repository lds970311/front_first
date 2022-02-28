// Author : evan lee
// Time ： 2022-02-24  15:00
// FILENAME : FactoryTest.java
// STATEMENT: 

package com.evanlee.construct;

import com.evanlee.construct.factorymode.abstractfactory.AmericanCoffeeFactory;
import com.evanlee.construct.factorymode.abstractfactory.AmericanDessertFactory;
import com.evanlee.construct.factorymode.abstractfactory.Dessert;
import com.evanlee.construct.factorymode.abstractfactory.DessertStore;
import com.evanlee.construct.factorymode.before.AbstractCoffee;
import com.evanlee.construct.factorymode.before.CoffeeStore;
import com.evanlee.construct.factorymode.configfactory.DessertConfigFactory;
import org.junit.jupiter.api.Test;

public class FactoryTest {
    @Test
    void coffeeStoreTest() {
        AbstractCoffee american = CoffeeStore.buyCoffee("American");
        System.out.println(american.getName());
    }

    @Test
    void simpleFactoryTest() {
        com.evanlee.construct.factorymode.simple.AbstractCoffee latte = com.evanlee.construct.factorymode.simple.CoffeeStore.buyCoffee("latte");
        System.out.println(latte.getName());
    }


    @Test
    void abstractMethodTest() {
        com.evanlee.construct.factorymode.abstractfactory.CoffeeStore store = new com.evanlee.construct.factorymode.abstractfactory.CoffeeStore(
                new AmericanCoffeeFactory()
        );
        com.evanlee.construct.factorymode.abstractfactory.AbstractCoffee coffee = store.buyCoffee();
        System.out.println(coffee.getName());
    }

    @Test
    void abstractFactoryTest() {
        DessertStore dessertStore = new DessertStore(
                new AmericanDessertFactory()
        );
        dessertStore.orderDessert();
       /* 抹茶慕斯
        add sugar
        add milk
        American coffee
        */
    }

    @Test
    void configFactoryTest() {
        Dessert trimisu = DessertConfigFactory.getDessert("trimisu");
        trimisu.show();
    }
}
