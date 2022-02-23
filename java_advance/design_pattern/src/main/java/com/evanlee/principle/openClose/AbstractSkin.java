// Author : evan lee
// Time ： 2022-02-21  21:02
// FILENAME : AbstractSkin.java
// STATEMENT: 

package com.evanlee.principle.openClose;

public abstract class AbstractSkin {

    public String skinName;

    public AbstractSkin(String skinName) {
        this.skinName = skinName;
    }

    public abstract void show();
}
