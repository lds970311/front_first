// Author : evan lee
// Time ： 2022-03-09  19:20
// FILENAME : CommandTest.java
// STATEMENT: 

package com.evanlee.behavior;

import com.evanlee.behavior.command.Order;
import com.evanlee.behavior.command.OrderCommand;
import com.evanlee.behavior.command.SeniorChef;
import com.evanlee.behavior.command.Waitor;
import org.junit.jupiter.api.Test;

public class CommandTest {
    @Test
    void command() {
        Order order1 = new Order();
        order1.setDiningTable(1);
        order1.getFoodDic().put("西红柿鸡蛋面", 1);
        order1.getFoodDic().put("小杯可乐", 2);

        Order order2 = new Order();
        order2.setDiningTable(3);
        order2.getFoodDic().put("尖椒肉丝盖饭", 1);
        order2.getFoodDic().put("小杯雪碧", 1);

        //创建接受者(厨师)
        SeniorChef seniorChef = new SeniorChef();
        //创建命令对象
        OrderCommand command1 = new OrderCommand(seniorChef, order1);
        OrderCommand command = new OrderCommand(seniorChef, order2);

        //创建调用者
        Waitor waitor = new Waitor();
        waitor.addCommand(command);
        waitor.addCommand(command1);
        waitor.orderUp();
    }
}
