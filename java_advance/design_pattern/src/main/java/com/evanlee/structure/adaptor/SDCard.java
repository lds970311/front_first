// Author : evan lee
// Time ： 2022-03-01  18:34
// FILENAME : SDCard.java
// STATEMENT: 

package com.evanlee.structure.adaptor;

public interface SDCard {
    //读取SD卡方法
    String readSD();

    //写入SD卡功能
    void writeSD(String msg);
}
