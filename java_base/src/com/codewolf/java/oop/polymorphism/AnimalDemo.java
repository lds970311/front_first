// Author : evan lee
// Time ： 2022-01-03  19:23
// FILENAME : AnimalDemo.java
// STATEMENT: 抽象类

package com.codewolf.java.oop.polymorphism;

abstract class Animal {

    private int age = 20;
    private final String city = "北京";

    public Animal() {
    }

    public Animal(int age) {
        this.age = age;
    }


    public void show() {
        age = 40;
        System.out.println(age);
        System.out.println(city);
    }

    public abstract void eat();
}

class Dog extends Animal {

    public Dog(int age) {
        super(age);
    }

    @Override
    public void eat() {
        System.out.println("dog is eating!");
    }
}


public class AnimalDemo {
    public static void main(String[] args) {
        Animal animal = new Dog(4);
        animal.show();
//        40
//        北京
        animal.eat(); //dog is eating!
    }
}
