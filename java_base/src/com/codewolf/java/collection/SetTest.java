// Author : evan lee
// Time ： 2022-01-05  16:34
// FILENAME : SetTest.java
// STATEMENT: 

package com.codewolf.java.collection;

import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class SetTest {
    @Test
    public void hashSet() {
        Set<String> set = new HashSet<>();
        set.add("1");
        set.add("3");
        set.add("5");
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public static void treeSet() {
        Apple apple = new Apple("红富士", "红色", 9.9, 500);
        Set<Apple> set = new TreeSet<Apple>((o1, o2) -> Double.compare(o1.getPrice(), o2.getPrice())); //shift+f6
        set.add(new Apple("红富士", "红色", 9.9, 500));
        set.add(new Apple("青苹果", "绿色", 15.9, 300));
        set.add(new Apple("绿苹果", "青色", 29.9, 400));
        set.add(new Apple("黄苹果", "黄色", 9.8, 500));
        System.out.println(set);
    }

    public static void main(String[] args) {
        treeSet();
    }
}


class Apple {
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String color;
    @Getter
    @Setter
    private double price;
    @Getter
    @Setter
    private int weight;

    public Apple() {
    }

    public Apple(String name, String color, double price, int weight) {
        this.name = name;
        this.color = color;
        this.price = price;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", weight=" + weight +
                '}';
    }
}