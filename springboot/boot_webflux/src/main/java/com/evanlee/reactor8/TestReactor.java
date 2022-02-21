// Author : evan lee
// Time ： 2022-02-20  22:24
// FILENAME : TestReactor.java
// STATEMENT: 

package com.evanlee.reactor8;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class TestReactor {
    public static void main(String[] args) {
        //创建发布者
        Flux.just(1, 2, 3, 4)
                .subscribe(System.out::println);
        Mono.just(1)
                .subscribe(System.out::println);

        //2.
        Flux.fromArray(new Integer[]{5, 6, 7, 8});
        Flux.fromIterable(Arrays.asList(98, 31));

        //3.
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        Stream<String> stream = list.stream();
        Flux.fromStream(stream);
    }
}
