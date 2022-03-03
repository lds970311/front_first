// Author : evan lee
// Time ： 2022-03-03  0:20
// FILENAME : Bacon.java
// STATEMENT: 

package com.evanlee.structure.decorator;

//培根配料
public class Bacon extends Garnish {

    public Bacon(FastFood fastFood) {
        super(fastFood, 14, "培根");
    }

    @Override
    public float cost() {
        return getPrice() + getFastFood().getPrice();
    }

    @Override
    public String getDesc() {
        return super.getDesc() + getFastFood().getDesc();
    }
}
