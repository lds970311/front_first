// Author : evan lee
// Time ： 2022-03-03  0:34
// FILENAME : DecoratorTest.java
// STATEMENT: 

package com.evanlee.structure;

import com.evanlee.structure.decorator.Bacon;
import com.evanlee.structure.decorator.Egg;
import com.evanlee.structure.decorator.FastFood;
import com.evanlee.structure.decorator.FiredNoodle;
import org.junit.jupiter.api.Test;

//装饰者模式测试
public class DecoratorTest {
    @Test
    void fastFoodTest() {
        FastFood firedNoodle = new FiredNoodle();
        firedNoodle = new Egg(firedNoodle);
        System.out.println(firedNoodle.getDesc()); //鸡蛋炒面
        System.out.println(firedNoodle.cost()); //1.0
        //加培根
        firedNoodle = new Bacon(firedNoodle);
        System.out.println(firedNoodle.getDesc()); //培根鸡蛋炒面
        System.out.println(firedNoodle.cost()); //1.0
    }
}
