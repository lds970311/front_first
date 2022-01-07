// Author : evan lee
// Time ： 2022-01-07  1:38
// FILENAME : CharSet.java
// STATEMENT: 

package com.codewolf.java.io;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class CharSet {
    @Test
    public void charSet() {
        String a = "你是谁";
        byte[] bytes = new byte[0];
        try {
            bytes = a.getBytes("GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(Arrays.toString(bytes));
        String s = null;
        try {
            s = new String(bytes, "GBK");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(s);
    }
}
