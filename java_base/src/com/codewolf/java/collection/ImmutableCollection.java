// Author : evan lee
// Time ： 2022-01-05  22:48
// FILENAME : ImmutableCollection.java
// STATEMENT: 

package com.codewolf.java.collection;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 不可变集合
 */
public class ImmutableCollection {
    @Test
    public void immutable() {
        List<Integer> list1 = List.of(1, 2, 3, 4); //不可变list
        //list1.add(12); //java.lang.UnsupportedOperationException
        Set<Integer> set1 = Set.of(5, 6, 7, 8);
        //set1.add(12);
        Map<Integer, String> map = Map.of(1, "123", 2, "234", 3, "456");
        Set<Integer> integers = map.keySet();
        for (Integer integer : integers) {
            System.out.println(map.get(integer));
        }
    }
}
