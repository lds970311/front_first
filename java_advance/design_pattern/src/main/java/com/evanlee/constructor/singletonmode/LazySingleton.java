// Author : evan lee
// Time ： 2022-02-22  12:43
// FILENAME : LazySingleton.java
// STATEMENT: 

package com.evanlee.constructor.singletonmode;

//懒汉式实现单例模式
public class LazySingleton {
    private LazySingleton() {
    }

    private static volatile LazySingleton singleton;


    public static LazySingleton getInstance() {
        if (singleton == null) {
            synchronized (LazySingleton.class) {
                if (singleton == null) {
                    singleton = new LazySingleton();
                }
            }
        }
        return singleton;
    }
}
