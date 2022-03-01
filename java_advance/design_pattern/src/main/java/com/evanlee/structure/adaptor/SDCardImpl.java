// Author : evan lee
// Time ： 2022-03-01  18:35
// FILENAME : SDCardImpl.java
// STATEMENT: 

package com.evanlee.structure.adaptor;

//SD卡实现类
public class SDCardImpl implements SDCard {

    @Override
    public String readSD() {
        return "sd card read a msg :hello word SD";
    }

    @Override
    public void writeSD(String msg) {
        System.out.println("sd card write msg : " + msg);
    }
}
