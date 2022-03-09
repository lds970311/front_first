// Author : evan lee
// Time ： 2022-03-09  20:36
// FILENAME : GeneralManager.java
// STATEMENT: 

package com.evanlee.behavior.chain;

//总经理
public class GeneralManager extends Handler {
    public GeneralManager() {
        super(Handler.NUM_SEVEN);
    }

    @Override
    protected void handleLeave(LeaveRequest leave) {
        System.out.println(leave.getName() + "请假" + leave.getNum() + "天," + leave.getContent() + "。");
        System.out.println("总经理审批：同意。");
    }
}
