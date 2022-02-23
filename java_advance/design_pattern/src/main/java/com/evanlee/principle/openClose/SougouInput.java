// Author : evan lee
// Time ： 2022-02-21  21:09
// FILENAME : SougouInput.java
// STATEMENT: 

package com.evanlee.principle.openClose;

import lombok.Getter;
import lombok.Setter;

/**
 * 输入法类
 */
public class SougouInput {

    @Getter
    @Setter
    private AbstractSkin skin;

    public SougouInput() {
    }

    public SougouInput(AbstractSkin skin) {
        this.skin = skin;
    }

    public void display() {
        this.skin.show();
    }
}
