// Author : evan lee
// Time ： 2022-03-01  18:38
// FILENAME : SDAdapterTF.java
// STATEMENT: 

package com.evanlee.structure.adaptor;

//定义适配器类（SD兼容TF）
public class SDAdapterTF extends TFCardImpl implements SDCard {

    @Override
    public String readSD() {
        System.out.println("adapter read tf card ");
        return super.readTF();
    }

    @Override
    public void writeSD(String msg) {
        System.out.println("adapter write tf card");
        super.writeTF(msg);
    }
}
