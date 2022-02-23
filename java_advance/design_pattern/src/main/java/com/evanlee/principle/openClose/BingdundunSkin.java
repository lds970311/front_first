// Author : evan lee
// Time ： 2022-02-21  21:08
// FILENAME : BingdundunSkin.java
// STATEMENT: 

package com.evanlee.principle.openClose;

/**
 * 冰墩墩皮肤
 */
public class BingdundunSkin extends AbstractSkin {

    public BingdundunSkin() {
        super("bingdundun skin");
    }

    @Override
    public void show() {
        System.out.println(this.skinName + "showing");
    }
}
