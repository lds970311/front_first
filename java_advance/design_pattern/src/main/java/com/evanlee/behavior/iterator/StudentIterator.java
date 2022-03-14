// Author : evan lee
// Time ： 2022-03-14  19:28
// FILENAME : StudentIterator.java
// STATEMENT: 

package com.evanlee.behavior.iterator;

//定义迭代器接口，声明hasNext、next方法
public interface StudentIterator {
    boolean hasNext();

    Student next();
}
