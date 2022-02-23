// Author : evan lee
// Time ： 2022-02-21  22:06
// FILENAME : Clinet.java
// STATEMENT: 

package com.evanlee.principle.dependencyInversion;

public class Client {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.setCpu(new AMDCpu());
        computer.setDisk(new SegateDisk());
        computer.setMemory(new KingstonMemory());
        computer.run();
        //计算机工作...
        // 5900X running
        //kingston saved
    }
}
