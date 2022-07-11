// Author : evan lee
// Time ： 2022-07-09  15:53
// FILENAME : HashTableTest.java
// STATEMENT: 

package cn.evan.safe;

import java.util.Hashtable;

public class HashTableTest {
    public static void main(String[] args) {
        Hashtable<String, String> hashtable = new Hashtable<>();

        new Thread(() -> {
            hashtable.put("1", "sam");
        }).start();

        new Thread(() -> {
            hashtable.put("2", "Joe");
        }).start();

    }
}
