// Author : evan lee
// Time ： 2022-02-20  21:51
// FILENAME : ObserveTest.java
// STATEMENT: 

package com.evanlee.reactor8;

import java.util.Observable;

public class ObserveTest extends Observable {
    public static void main(String[] args) {
        ObserveTest observeTest = new ObserveTest();
        //添加观察者
        observeTest.addObserver((o, arg) -> {
            System.out.println("happen:");
        });
        observeTest.setChanged(); //数据变化
        observeTest.notifyObservers();//通知
    }
}
