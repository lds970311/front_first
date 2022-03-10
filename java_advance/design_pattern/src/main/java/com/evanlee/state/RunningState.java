// Author : evan lee
// Time ： 2022-03-09  22:49
// FILENAME : RunningState.java
// STATEMENT: 

package com.evanlee.state;

public class RunningState extends LiftState {

    @Override
    public void open() {
        //do nothing
    }

    @Override
    public void close() {
        //do nothing
    }

    @Override
    public void run() {
        System.out.println("电梯正在运行...");
    }

    @Override
    public void stop() {
        super.context.setLiftState(Context.stoppingState);
        super.context.stop();
    }
}
