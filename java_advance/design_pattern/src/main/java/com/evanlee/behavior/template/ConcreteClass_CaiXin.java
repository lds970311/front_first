// Author : evan lee
// Time ： 2022-03-07  20:47
// FILENAME : ConcreteClass_CaiXin.java
// STATEMENT: 

package com.evanlee.behavior.template;

public class ConcreteClass_CaiXin extends AbstractClass {

    @Override
    public void pourVegetable() {
        System.out.println("下锅的蔬菜是菜心");
    }

    @Override
    public void pourSauce() {
        System.out.println("下锅的酱料是蒜蓉");
    }
}
