// Author : evan lee
// Time ： 2022-03-07  22:11
// FILENAME : StrategyB.java
// STATEMENT: 

package com.evanlee.behavior.strategy;

public class StrategyB implements Strategy {

    @Override
    public void show() {
        System.out.println("满200元减50元");
    }
}
