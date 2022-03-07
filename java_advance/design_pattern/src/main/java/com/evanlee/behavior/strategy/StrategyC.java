// Author : evan lee
// Time ： 2022-03-07  22:12
// FILENAME : StrategyC.java
// STATEMENT: 

package com.evanlee.behavior.strategy;

public class StrategyC implements Strategy {

    @Override
    public void show() {
        System.out.println("满1000元加一元换购任意200元以下商品");
    }
}
