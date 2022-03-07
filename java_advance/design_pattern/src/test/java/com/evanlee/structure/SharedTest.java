// Author : evan lee
// Time ： 2022-03-07  19:28
// FILENAME : SharedTest.java
// STATEMENT: 

package com.evanlee.structure;

import com.evanlee.structure.shared.AbstractBox;
import com.evanlee.structure.shared.BoxFactory;
import org.junit.jupiter.api.Test;

/**
 * 享元模式测试
 */
public class SharedTest {
    @Test
    void boxTest() {
        BoxFactory boxFactory = BoxFactory.getInstance();
        AbstractBox i = boxFactory.getBox("I");
        AbstractBox i2 = boxFactory.getBox("I");
        System.out.println(i.getShape());
        i.display("green"); //方块形状：I 颜色：green
        System.out.println(i == i2); //true
    }
}
