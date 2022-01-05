// Author : evan lee
// Time ： 2022-01-04  22:50
// FILENAME : CollectionList.java
// STATEMENT: 

package com.codewolf.java.collection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class CollectionList {

    @Test
    public void arrayList() {
        Collection<Integer> list = new ArrayList<>();
        list.add(1);
        Integer[] array = (Integer[]) list.toArray();
        System.out.println(Arrays.toString(array));
    }
}
