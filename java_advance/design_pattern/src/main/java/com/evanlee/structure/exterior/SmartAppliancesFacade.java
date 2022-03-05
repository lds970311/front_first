// Author : evan lee
// Time ： 2022-03-05  13:59
// FILENAME : SmartAppliancesFacade.java
// STATEMENT: 

package com.evanlee.structure.exterior;

//智能音响
public class SmartAppliancesFacade {
    private final Light light;
    private final TV tv;
    private final AirCondition airCondition;

    public SmartAppliancesFacade() {
        this.light = new Light();
        this.tv = new TV();
        this.airCondition = new AirCondition();
    }

    //起床后一键开电器
    private void on() {
        light.on();
        tv.on();
        airCondition.on();
    }

    //睡觉一键关电器
    private void off() {
        light.off();
        tv.off();
        airCondition.off();
    }

    public void say(String message) {
        if (message.contains("打开")) {
            this.on();
        } else if (message.contains("关闭")) {
            this.off();
        } else {
            System.out.println("我还听不懂你说的！！！");
        }
    }
}
