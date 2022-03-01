// Author : evan lee
// Time ： 2022-03-01  18:37
// FILENAME : Computer.java
// STATEMENT: 

package com.evanlee.structure.adaptor;

//电脑类
public class Computer {
    public String readSD(SDCard sdCard) {
        if (sdCard == null) {
            throw new NullPointerException("sd card null");
        }
        return sdCard.readSD();
    }

    public void writeSD(String data, SDCard sdCard) {
        sdCard.writeSD(data);
    }
}
