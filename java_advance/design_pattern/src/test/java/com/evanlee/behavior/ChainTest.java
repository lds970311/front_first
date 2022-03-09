// Author : evan lee
// Time ： 2022-03-09  20:37
// FILENAME : ChainTest.java
// STATEMENT: 

package com.evanlee.behavior;

import com.evanlee.behavior.chain.GeneralManager;
import com.evanlee.behavior.chain.GroupLeader;
import com.evanlee.behavior.chain.LeaveRequest;
import com.evanlee.behavior.chain.Manager;
import org.junit.jupiter.api.Test;

public class ChainTest {
    @Test
    void chain() {
        //创建三个handler子类对象,设置上下级关系
        GroupLeader groupLeader = new GroupLeader();
        Manager manager = new Manager();
        GeneralManager generalManager = new GeneralManager();
        groupLeader.setNextHandler(manager);
        manager.setNextHandler(generalManager);

        //张三提交小组长请假单
        groupLeader.submit(new LeaveRequest("张三", 10, "老婆生了!"));
        /*
            张三请假10天,老婆生了!。
            小组长审批：同意。
            张三请假10天,老婆生了!。
            经理审批：同意。
            张三请假10天,老婆生了!。
            总经理审批：同意。
            流程结束
        */
    }
}
