// Author : evan lee
// Time ： 2022-03-09  23:02
// FILENAME : StateTest.java
// STATEMENT: 

package com.evanlee.behavior;

import com.evanlee.behavior.state.Context;
import com.evanlee.behavior.state.RunningState;
import org.junit.jupiter.api.Test;

//状态模式测试
public class StateTest {
    @Test
    void state() {
        Context context = new Context();
        context.setLiftState(new RunningState());
        context.open();
        context.close();
        context.run();
        context.stop();
    }
}
