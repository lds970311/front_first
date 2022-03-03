// Author : evan lee
// Time ： 2022-03-03  0:19
// FILENAME : Egg.java
// STATEMENT: 

package com.evanlee.structure.decorator;

//鸡蛋配料
public class Egg extends Garnish {
    public Egg(FastFood fastFood) {
        super(fastFood, 1, "鸡蛋");
    }

    public float cost() {
        return super.getPrice() + getFastFood().getPrice();
    }

    @Override
    public String getDesc() {
        return super.getDesc() + getFastFood().getDesc();
    }
}
