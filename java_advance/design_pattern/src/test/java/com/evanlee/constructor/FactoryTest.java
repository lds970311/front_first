// Author : evan lee
// Time ： 2022-02-24  15:00
// FILENAME : FactoryTest.java
// STATEMENT: 

package com.evanlee.constructor;

import com.evanlee.constructor.factorymode.abstractfactory.AmericanCoffeeFactory;
import com.evanlee.constructor.factorymode.abstractfactory.AmericanDessertFactory;
import com.evanlee.constructor.factorymode.abstractfactory.Dessert;
import com.evanlee.constructor.factorymode.abstractfactory.DessertStore;
import com.evanlee.constructor.factorymode.before.AbstractCoffee;
import com.evanlee.constructor.factorymode.before.CoffeeStore;
import com.evanlee.constructor.factorymode.configfactory.DessertConfigFactory;
import org.junit.jupiter.api.Test;

public class FactoryTest {
    @Test
    void coffeeStoreTest() {
        AbstractCoffee american = CoffeeStore.buyCoffee("American");
        System.out.println(american.getName());
    }

    @Test
    void simpleFactoryTest() {
        com.evanlee.constructor.factorymode.simple.AbstractCoffee latte = com.evanlee.constructor.factorymode.simple.CoffeeStore.buyCoffee("latte");
        System.out.println(latte.getName());
    }


    @Test
    void abstractMethodTest() {
        com.evanlee.constructor.factorymode.abstractfactory.CoffeeStore store = new com.evanlee.constructor.factorymode.abstractfactory.CoffeeStore(
                new AmericanCoffeeFactory()
        );
        com.evanlee.constructor.factorymode.abstractfactory.AbstractCoffee coffee = store.buyCoffee();
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
