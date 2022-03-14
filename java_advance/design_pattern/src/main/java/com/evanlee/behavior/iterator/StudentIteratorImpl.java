// Author : evan lee
// Time ： 2022-03-14  19:29
// FILENAME : StudentIteratorImpl.java
// STATEMENT: 

package com.evanlee.behavior.iterator;


import java.util.List;

//定义具体的迭代器类，重写所有的抽象方法
public class StudentIteratorImpl implements StudentIterator {
    private List<Student> list;
    private int position = 0;

    public StudentIteratorImpl(List<Student> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return this.position < this.list.size();
    }

    @Override
    public Student next() {
        Student student = list.get(position);
        position++;
        return student;
    }
}
