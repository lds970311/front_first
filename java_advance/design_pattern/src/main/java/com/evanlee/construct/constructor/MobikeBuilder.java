// Author : evan lee
// Time ： 2022-02-28  16:16
// FILENAME : MobikeBuilder.java
// STATEMENT: 

package com.evanlee.construct.constructor;

/**
 * 具体建造者类（ConcreteBuilder）
 */
public class MobikeBuilder extends Builder {

    @Override
    public void buildFrame() {
        super.mBike.setFrame("铝合金车架");
    }

    @Override
    public void buildSeat() {
        super.mBike.setSeat("真皮车座");
    }

    @Override
    public Bike createBike() {
        return super.mBike;
    }
}
