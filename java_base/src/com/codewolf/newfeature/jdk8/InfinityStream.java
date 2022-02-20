// Author : evan lee
// Time ： 2022-02-20  14:19
// FILENAME : InfinityStream.java
// STATEMENT: 

package com.codewolf.newfeature.jdk8;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

public class InfinityStream {
    @Test
    public void testStream() {
        // 迭代
        Stream<Integer> stream = Stream.iterate(0, x -> x + 2);
        stream.limit(10).forEach(System.out::println);

        // 生成
        Stream<Double> stream1 = Stream.generate(Math::random);
        stream1.limit(10).forEach(System.out::println);
    }
}
