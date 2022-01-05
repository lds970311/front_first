// Author : evan lee
// Time ： 2022-01-05  23:03
// FILENAME : StreamAPIS.java
// STATEMENT: 

package com.codewolf.java.collection.streams;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


public class StreamAPIS {
    @Test
    public void stream() {
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("周芷若");
        list.add("赵敏");
        list.add("张强");
        list.add("张三丰");
        list.add("张三丰");
        list.stream()
                .filter(man -> man.startsWith("张"))
                .distinct()
                .map(s -> s += "北京的")
                .forEach(System.out::println);
    }

    @Test
    public void stream2() {
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(19);
        list.add(121);
        //计算stream流中的和
        Integer result = list.stream()
                .reduce(Integer::sum)
                .get();
        System.out.println(result);
    }
}
