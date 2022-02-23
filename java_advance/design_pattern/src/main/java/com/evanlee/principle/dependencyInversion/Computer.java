// Author : evan lee
// Time ： 2022-02-21  22:01
// FILENAME : Computer.java
// STATEMENT: 

package com.evanlee.principle.dependencyInversion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Computer {
    private Cpu cpu;
    private Memory memory;
    private Disk disk;

    public void run() {
        System.out.println("计算机工作...");
        this.cpu.run();
        this.memory.save();
        this.disk.saveData("呵呵");
    }
}
