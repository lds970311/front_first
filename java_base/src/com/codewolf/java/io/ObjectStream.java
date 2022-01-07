// Author : evan lee
// Time ： 2022-01-07  21:05
// FILENAME : ObjectStream.java
// STATEMENT: 对象输入输出流

package com.codewolf.java.io;

import org.junit.Test;

import java.io.*;

class Student implements Serializable {
    // 申明序列化的版本号码
    // 序列化的版本号与反序列化的版本号必须一致才不会出错！
    private static final long serialVersionUID = 1;
    private String name;
    private String loginName;
    // transient修饰的成员变量不参与序列化了
    private transient String passWord;
    private int age;

    public Student() {
    }

    public Student(String name, String loginName, String passWord, int age) {
        this.name = name;
        this.loginName = loginName;
        this.passWord = passWord;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", loginName='" + loginName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", age=" + age +
                '}';
    }
}


public class ObjectStream {
    @Test
    public void writerObj() throws IOException {
        Student s = new Student("陈磊", "chenlei", "1314520", 21);
        Student s2 = new Student("陈磊", "Lily", "1314520", 21);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("F:\\Java\\front_first\\java_base\\testfiles\\object.txt"));
        oos.writeObject(s);
        oos.writeObject(s2);
        oos.close();
    }

    @Test
    public void readObj() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("F:\\Java\\front_first\\java_base\\testfiles\\object.txt"));
        Object o;
        while ((o = ois.readObject()) != null) {
            System.out.println(o);
        }
        System.out.println(o);
    }
}
