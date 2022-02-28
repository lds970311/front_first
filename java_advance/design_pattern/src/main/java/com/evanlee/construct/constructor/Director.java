// Author : evan lee
// Time ： 2022-02-28  16:17
// FILENAME : Director.java
// STATEMENT: 

package com.evanlee.construct.constructor;

/**
 * 指挥者类（Director
 */
public class Director {
    private final Builder bikeBuilder;

    public Director(Builder bikeBuilder) {
        this.bikeBuilder = bikeBuilder;
    }

    public Bike constructBike() {
        bikeBuilder.buildSeat();
        bikeBuilder.buildFrame();
        return bikeBuilder.createBike();
    }
}
