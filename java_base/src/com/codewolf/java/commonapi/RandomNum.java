package com.codewolf.java.commonapi;

// Author : CSR丶SUSE
// Time ： 2022-01-01  19:36
// FILENAME : RandomNum.java
// STATEMENT: Random类


import org.junit.Test;

import java.util.Random;

public class RandomNum {
    @Test
    public void random() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int num = random.nextInt(100);
            System.out.println(num);
        }
    }
}
