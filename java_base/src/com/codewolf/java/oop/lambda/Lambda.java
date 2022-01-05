// Author : evan lee
// Time ： 2022-01-04  22:01
// FILENAME : Lambda.java
// STATEMENT: 

package com.codewolf.java.oop.lambda;

@FunctionalInterface
interface Man {
    void eat(int a);
}

public class Lambda {
    public static void swim(Man m) {
        m.eat(34);
    }

    public static void main(String[] args) {
        new Thread(() -> System.out.println("123")).start();

        swim(System.out::println);
    }
}