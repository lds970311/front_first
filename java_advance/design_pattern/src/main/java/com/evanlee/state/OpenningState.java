// Author : evan lee
// Time ： 2022-03-09  22:48
// FILENAME : OpenningState.java
// STATEMENT: 

package com.evanlee.state;

public class OpenningState extends LiftState {

    @Override
    public void open() {
        System.out.println("电梯门开启...");
    }

    @Override
    public void close() {
        //状态修改
        super.context.setLiftState(Context.closeingState);
        //动作委托为CloseState来执行，也就是委托给了ClosingState子类执行这个动作
        super.context.getLiftState().close();
    }

    @Override
    public void run() {
        //do nothing
    }

    @Override
    public void stop() {
        //do nothing
    }
}
