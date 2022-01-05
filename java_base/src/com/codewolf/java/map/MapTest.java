// Author : evan lee
// Time ： 2022-01-05  20:17
// FILENAME : MapTest.java
// STATEMENT: 

package com.codewolf.java.map;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTest {
    @Test
    public void hashMap() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Sam");
        map.put(2, "Louis");
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        for (Map.Entry<Integer, String> entry : entries) {
            System.out.println(entry);
        }
        String s = map.get(1);
        map.containsKey(1);
    }

    @Test
    public void forEach() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Sam");
        map.put(2, "Louis");
        map.forEach((integer, s) -> System.out.printf("%d-%s\n", integer, s));
    }
}
