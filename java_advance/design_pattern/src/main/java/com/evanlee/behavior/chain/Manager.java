// Author : evan lee
// Time ： 2022-03-09  20:35
// FILENAME : Manager.java
// STATEMENT: 

package com.evanlee.behavior.chain;

public class Manager extends Handler {
    public Manager() {
        super(Handler.NUM_THREE, Handler.NUM_SEVEN);
    }

    @Override
    protected void handleLeave(LeaveRequest leave) {
        System.out.println(leave.getName() + "请假" + leave.getNum() + "天," + leave.getContent() + "。");
        System.out.println("经理审批：同意。");
    }
}
