// Author : evan lee
// Time ： 2022-03-14  20:53
// FILENAME : VisitorTest.java
// STATEMENT: 

package com.evanlee.behavior;

import com.evanlee.behavior.visitor.*;
import org.junit.jupiter.api.Test;

public class VisitorTest {
    @Test
    void visitorTest() {
        Home home = new Home();
        home.add(new Cat());
        home.add(new Dog());
        home.action(new Owner());
        home.action(new Someone());
    }
}
