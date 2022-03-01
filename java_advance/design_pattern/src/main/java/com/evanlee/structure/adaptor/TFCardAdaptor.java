// Author : evan lee
// Time ： 2022-03-01  19:08
// FILENAME : TFCardAdaptor.java
// STATEMENT: 

package com.evanlee.structure.adaptor;

public class TFCardAdaptor implements SDCard {
    private TFCard tfCard; //聚合

    public TFCardAdaptor(TFCard tfCard) {
        this.tfCard = tfCard;
    }


    @Override
    public String readSD() {
        return tfCard.readTF();
    }

    @Override
    public void writeSD(String msg) {
        tfCard.writeTF(msg);
    }
}
