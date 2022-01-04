// Author : evan lee
// Time ： 2022-01-03  23:39
// FILENAME : ArrayAPI.java
// STATEMENT: 

package com.codewolf.java.commonapi;

import org.junit.Test;

import java.util.Arrays;

public class ArrayAPI {
    @Test
    public void arrays() {
        //定义一个数组
        int[] arr = {24, 69, 80, 57, 13};

        System.out.println("排序前：" + Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println("排序后：" + Arrays.toString(arr));

    }
}
