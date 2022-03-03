// Author : evan lee
// Time ： 2022-03-03  0:26
// FILENAME : FiredNoodle.java
// STATEMENT: 

package com.evanlee.structure.decorator;

//炒面
public class FiredNoodle extends FastFood {

    public FiredNoodle() {
        super(3, "炒面");
    }

    @Override
    public float cost() {
        return super.getPrice();
    }
}
