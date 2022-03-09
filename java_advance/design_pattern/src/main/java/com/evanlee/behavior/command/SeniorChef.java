// Author : evan lee
// Time ： 2022-03-09  18:54
// FILENAME : SeniorChef.java
// STATEMENT: 

package com.evanlee.behavior.command;

// 资深大厨类 是命令的Receiver
public class SeniorChef {

    public void makeFood(int num, String foodName) {
        System.out.println(num + "份" + foodName);
    }
}
