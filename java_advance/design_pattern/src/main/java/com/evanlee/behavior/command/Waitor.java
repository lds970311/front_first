// Author : evan lee
// Time ： 2022-03-09  19:14
// FILENAME : Waitor.java
// STATEMENT: 

package com.evanlee.behavior.command;

import java.util.ArrayList;

public class Waitor {
    private final ArrayList<Command> commands;//可以持有很多的命令对象

    public Waitor() {
        commands = new ArrayList();
    }

    public void addCommand(Command command) {
        this.commands.add(command);
    }

    public Waitor(ArrayList<Command> commands) {
        this.commands = commands;
    }

    public void setCommand(Command cmd) {
        commands.add(cmd);
    }

    // 发出命令 喊 订单来了，厨师开始执行
    public void orderUp() {
        System.out.println("美女服务员：叮咚，大厨，新订单来了.......");
        for (Command cmd : commands) {
            if (cmd != null) {
                cmd.execute();
            }
        }
    }
}
