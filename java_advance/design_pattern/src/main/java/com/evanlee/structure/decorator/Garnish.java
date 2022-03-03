// Author : evan lee
// Time ： 2022-03-03  0:18
// FILENAME : Garnish.java
// STATEMENT: 

package com.evanlee.structure.decorator;

import lombok.Getter;
import lombok.Setter;

//配料类
public abstract class Garnish extends FastFood {
    @Getter
    @Setter
    private FastFood fastFood;

    public Garnish(FastFood fastFood, float price, String desc) {
        super(price, desc);
        this.fastFood = fastFood;
    }
}
