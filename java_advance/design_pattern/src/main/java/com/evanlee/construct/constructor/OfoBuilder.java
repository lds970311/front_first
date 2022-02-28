// Author : evan lee
// Time ： 2022-02-28  16:16
// FILENAME : OfoBuilder.java
// STATEMENT: 

package com.evanlee.construct.constructor;

/**
 * 具体建造者类（ConcreteBuilder）
 */
public class OfoBuilder extends Builder {

    @Override
    public void buildFrame() {
        super.mBike.setFrame("碳纤维车架");
    }

    @Override
    public void buildSeat() {
        super.mBike.setSeat("橡胶车座");
    }

    @Override
    public Bike createBike() {
        return super.mBike;
    }
}
