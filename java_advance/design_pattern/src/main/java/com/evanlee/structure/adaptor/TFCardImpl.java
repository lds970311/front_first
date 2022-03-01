// Author : evan lee
// Time ： 2022-03-01  18:36
// FILENAME : TFCardImpl.java
// STATEMENT: 

package com.evanlee.structure.adaptor;

//TF卡实现类
public class TFCardImpl implements TFCard {

    @Override
    public String readTF() {
        return "tf card read msg : hello word tf card";
    }

    @Override
    public void writeTF(String msg) {
        System.out.println("tf card write a msg : " + msg);
    }
}
