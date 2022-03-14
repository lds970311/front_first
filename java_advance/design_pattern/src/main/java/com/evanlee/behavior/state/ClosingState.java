// Author : evan lee
// Time ： 2022-03-09  22:50
// FILENAME : ClosingState.java
// STATEMENT: 

package com.evanlee.behavior.state;

public class ClosingState extends LiftState {

    @Override
    public void open() {
        super.context.setLiftState(Context.openningState);
        super.context.open();
    }

    @Override
    public void close() {
        System.out.println("电梯门关闭...");
    }

    @Override
    public void run() {
        super.context.setLiftState(Context.runningState);
        super.context.run();
    }

    @Override
    public void stop() {
        super.context.setLiftState(Context.stoppingState);
        super.context.stop();
    }
}
