// Author : evan lee
// Time ： 2022-01-03  22:05
// FILENAME : InnerClass.java
// STATEMENT: 

package com.codewolf.java.oop.innerclass;

public class OuterClass {
    private int num = 10;

    //成员内部类
    private class Inner {
        private String address = "beijing";

        public void show(String str) {
            System.out.println(str);
        }
    }

    public void myOuter() {
        //局部内部类
        class MethodInner {
            private final int time = 0;

            public void speak() {
                System.out.println("speak!");
            }
        }

        new MethodInner().speak();
    }

    public void callInnerMethod(String s) {
        new Inner().show(s);
    }

    public static void main(String[] args) {
        OuterClass outerClass = new OuterClass();
        outerClass.myOuter();
        outerClass.callInnerMethod("this is inner!");
    }
}
