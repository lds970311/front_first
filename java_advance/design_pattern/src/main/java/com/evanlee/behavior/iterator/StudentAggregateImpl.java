// Author : evan lee
// Time ： 2022-03-14  19:31
// FILENAME : StudentAggregateImpl.java
// STATEMENT: 

package com.evanlee.behavior.iterator;

import java.util.ArrayList;
import java.util.List;

public class StudentAggregateImpl implements StudentAggregate {
    private final List<Student> list = new ArrayList<>();  // 学生列表


    @Override
    public void addStudent(Student student) {
        list.add(student);
    }

    @Override
    public void removeStudent(Student student) {
        list.remove(student);
    }

    @Override
    public StudentIterator getStudentIterator() {
        return new StudentIteratorImpl(list);
    }
}
