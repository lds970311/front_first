// Author : evan lee
// Time ： 2022-03-05  14:02
// FILENAME : ExteriorTest.java
// STATEMENT: 

package com.evanlee.structure;

import com.evanlee.structure.exterior.SmartAppliancesFacade;
import org.junit.jupiter.api.Test;

public class ExteriorTest {
    @Test
    void smartTest() {
        SmartAppliancesFacade smartAppliancesFacade = new SmartAppliancesFacade();
        smartAppliancesFacade.say("打开电器!!");
        /* 打开了灯....
        打开了电视....
        打开了空调....
        */
    }
}
