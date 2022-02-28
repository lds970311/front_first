// Author : evan lee
// Time ： 2022-02-28  14:40
// FILENAME : PrototypeTest.java
// STATEMENT: 

package com.evanlee.construct;

import com.evanlee.construct.prototypemode.Citation;
import com.evanlee.construct.prototypemode.Realizetype;
import com.evanlee.construct.prototypemode.Student;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PrototypeTest {
    @SneakyThrows
    @Test
    void prototypeTest() {
        Realizetype realizetype = new Realizetype();
        Realizetype clone = realizetype.clone();
        System.out.println(realizetype == clone); //false
    }

    @Test
    void citationTest() throws CloneNotSupportedException {
        Citation c1 = new Citation();
        Student stu = new Student("张三", "西安");
        c1.setStu(stu);

        //复制奖状
        Citation c2 = c1.clone();
        //获取c2奖状所属学生对象
        Student stu1 = c2.getStu();
        stu1.setName("李四");

        //判断stu对象和stu1对象是否是同一个对象
        System.out.println("stu和stu1是同一个对象？" + (stu == stu1));

        c1.show();
        c2.show();
    }

    @SneakyThrows
    @Test
    void deepCloneTest() {
        Citation c1 = new Citation();
        Student stu = new Student("张三", "西安");
        c1.setStu(stu);

        //创建对象输出流对象
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("F:\\Java\\front_first\\java_advance\\design_pattern\\src\\test\\resources\\citation.txt"));
        //将c1对象写出到文件中
        oos.writeObject(c1);
        oos.close();

        //创建对象出入流对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("F:\\Java\\front_first\\java_advance\\design_pattern\\src\\test\\resources\\citation.txt"));
        //读取对象
        Citation c2 = (Citation) ois.readObject();
        ois.close();
        //获取c2奖状所属学生对象
        Student stu1 = c2.getStu();
        stu1.setName("李四");

        //判断stu对象和stu1对象是否是同一个对象
        System.out.println("stu和stu1是同一个对象？" + (stu == stu1));

        c1.show();
        c2.show();
    }
}
