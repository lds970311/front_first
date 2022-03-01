// Author : evan lee
// Time ： 2022-03-01  18:36
// FILENAME : TFCard.java
// STATEMENT: 

package com.evanlee.structure.adaptor;

//TF卡接口
public interface TFCard {
    //读取TF卡方法
    String readTF();

    //写入TF卡功能
    void writeTF(String msg);
}
