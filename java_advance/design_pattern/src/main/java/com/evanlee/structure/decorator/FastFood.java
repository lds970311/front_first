// Author : evan lee
// Time ： 2022-03-03  0:15
// FILENAME : FastFood.java
// STATEMENT: 

package com.evanlee.structure.decorator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//快餐类
@NoArgsConstructor
@Data
@AllArgsConstructor
public abstract class FastFood {
    private float price;
    private String desc;

    public abstract float cost();  //获取价格
}
