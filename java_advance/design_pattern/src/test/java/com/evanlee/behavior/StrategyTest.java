// Author : evan lee
// Time ： 2022-03-07  22:13
// FILENAME : StrategyTest.java
// STATEMENT: 

package com.evanlee.behavior;

import com.evanlee.behavior.strategy.SalesMan;
import com.evanlee.behavior.strategy.StrategyB;
import org.junit.jupiter.api.Test;

public class StrategyTest {

    @Test
    void strategy() {
        SalesMan salesMan = new SalesMan(new StrategyB());
        salesMan.salesManShow(); //满200元减50元
    }
}
