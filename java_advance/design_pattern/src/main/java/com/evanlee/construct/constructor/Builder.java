// Author : evan lee
// Time ： 2022-02-28  16:15
// FILENAME : Builder.java
// STATEMENT: 

package com.evanlee.construct.constructor;

/**
 * 抽象建造者类（Builder）
 */
public abstract class Builder {
    protected Bike mBike = new Bike();

    public abstract void buildFrame();

    public abstract void buildSeat();

    public abstract Bike createBike();
}
