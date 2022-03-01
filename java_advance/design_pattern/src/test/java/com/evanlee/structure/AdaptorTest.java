// Author : evan lee
// Time ： 2022-03-01  18:40
// FILENAME : AdaptorTest.java
// STATEMENT: 

package com.evanlee.structure;

import com.evanlee.structure.adaptor.*;
import org.junit.jupiter.api.Test;

public class AdaptorTest {

    @Test
    void adaptorTest() {
        Computer computer = new Computer();
        String s = computer.readSD(new SDAdapterTF());
        System.out.println(s);
        // adapter read tf card
        //tf card read msg : hello word tf card
        computer.writeSD("hello", new SDAdapterTF());
        //adapter write tf card
        //tf card write a msg : hello

    }

    @Test
    void tfAdapterTest() {
        Computer computer = new Computer();
        TFCard tfCard = new TFCardImpl();
        String s = computer.readSD(new TFCardAdaptor(tfCard));
        System.out.println(s);
        computer.writeSD("when??", new TFCardAdaptor(tfCard));
    }
}
