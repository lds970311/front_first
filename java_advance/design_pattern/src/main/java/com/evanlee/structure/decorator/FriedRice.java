// Author : evan lee
// Time ： 2022-03-03  0:16
// FILENAME : FriedRice.java
// STATEMENT: 

package com.evanlee.structure.decorator;

//炒面类
public class FriedRice extends FastFood {

    public FriedRice() {
        super(12, "炒饭");
    }

    @Override
    public float cost() {
        return super.getPrice();
    }
}
