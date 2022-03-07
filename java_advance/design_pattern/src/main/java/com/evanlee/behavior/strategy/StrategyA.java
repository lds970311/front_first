// Author : evan lee
// Time ： 2022-03-07  22:11
// FILENAME : StrategyA.java
// STATEMENT: 

package com.evanlee.behavior.strategy;

public class StrategyA implements Strategy {

    @Override
    public void show() {
        System.out.println("买一送一");
    }
}
