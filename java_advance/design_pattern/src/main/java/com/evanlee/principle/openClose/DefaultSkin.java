// Author : evan lee
// Time ： 2022-02-21  21:02
// FILENAME : DefaultSkin.java
// STATEMENT: 

package com.evanlee.principle.openClose;

/**
 * 默认皮肤
 */
public class DefaultSkin extends AbstractSkin {

    public DefaultSkin() {
        super("defalut skin");
    }

    @Override
    public void show() {
        System.out.println(this.skinName + "showing");
    }
}
