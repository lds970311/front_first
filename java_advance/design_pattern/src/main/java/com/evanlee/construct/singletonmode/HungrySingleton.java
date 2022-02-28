// Author : evan lee
// Time ： 2022-02-22  0:57
// FILENAME : HungrySingleton.java
// STATEMENT: 

package com.evanlee.construct.singletonmode;

//饿汉式
public class HungrySingleton {
    //1.私有化构造器
    private HungrySingleton() {

    }

    //2. 类中创建本类对象
    private static final HungrySingleton instance;

    static {
        instance = new HungrySingleton();
    }

    //3. 提供公共访问方式, 让外界获取该对象
    public static HungrySingleton getInstance() {
        return instance;
    }
}
