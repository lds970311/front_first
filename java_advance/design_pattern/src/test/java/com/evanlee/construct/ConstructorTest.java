// Author : evan lee
// Time ： 2022-02-28  16:14
// FILENAME : ConstructorTest.java
// STATEMENT: 

package com.evanlee.construct;

import com.evanlee.construct.constructor.Bike;
import com.evanlee.construct.constructor.Director;
import com.evanlee.construct.constructor.MobikeBuilder;
import com.evanlee.construct.constructor.OfoBuilder;
import org.junit.jupiter.api.Test;

public class ConstructorTest {
    @Test
    void createBikeTest() {
        Director director = new Director(new MobikeBuilder());
        Bike bike = director.constructBike();
        System.out.println(bike.getFrame());//铝合金车架
        System.out.println(bike.getSeat()); //真皮车座
        Director director1 = new Director(new OfoBuilder());
        Bike bike1 = director1.constructBike();
        System.out.println(bike1.getFrame()); //碳纤维车架
        System.out.println(bike1.getSeat()); //橡胶车座
    }
}
