// Author : evan lee
// Time ： 2022-03-14  19:35
// FILENAME : IterTest.java
// STATEMENT: 

package com.evanlee.behavior;

import com.evanlee.behavior.iterator.Student;
import com.evanlee.behavior.iterator.StudentAggregate;
import com.evanlee.behavior.iterator.StudentAggregateImpl;
import com.evanlee.behavior.iterator.StudentIterator;
import org.junit.jupiter.api.Test;

public class IterTest {
    @Test
    void iter() {
        StudentAggregate studentAggregate = new StudentAggregateImpl();
        studentAggregate.addStudent(new Student("安妮", "001"));
        studentAggregate.addStudent(new Student("塞拉斯", "002"));
        studentAggregate.addStudent(new Student("维克托", "003"));
        studentAggregate.addStudent(new Student("卢锡安", "004"));
        StudentIterator studentIterator = studentAggregate.getStudentIterator();
        while (studentIterator.hasNext()) {
            System.out.println(studentIterator.next());
        }
    }
}
