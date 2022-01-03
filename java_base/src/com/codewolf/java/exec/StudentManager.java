// Author : evan lee
// Time ： 2022-01-02  22:12
// FILENAME : StudentManager.java
// STATEMENT: 学生管理系统

package com.codewolf.java.exec;

import java.util.ArrayList;
import java.util.Scanner;


class Student {
    private int id;
    private String name;
    private int age;
    private String address;

    public Student() {
    }

    public Student(int id, String name, int age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}


public class StudentManager {
    public static void showMenu() {
        //用输出语句完成主界面的编写
        System.out.println("--------欢迎来到学生管理系统--------");
        System.out.println("1 添加学生");
        System.out.println("2 删除学生");
        System.out.println("3 修改学生");
        System.out.println("4 查看所有学生");
        System.out.println("5 退出");
        System.out.println("请输入你的选择：");
    }

    public static void main(String[] args) {
        ArrayList<Student> all = new ArrayList<>();
        boolean flag = true;
        do {
            Scanner scanner = new Scanner(System.in);
            showMenu();
            int i = scanner.nextInt();
            switch (i) {
                case 1:
                    addStudent(all);
                    break;
                case 2:
                    deleteStudent(all);
                    break;
                case 3:
                    modify(all);
                    break;
                case 4:
                    checkAllStudents(all);
                    break;
                case 5:
                    flag = false;
                    break;
                default:
                    System.out.println("输入有误,请重新输入!");
            }
        } while (flag);
    }

    public static void checkAllStudents(ArrayList<Student> all) {
        System.out.println("学号\t\t\t姓名\t\t年龄\t\t居住地");
        for (Student student : all) {
            System.out.printf("%d\t\t\t%s\t\t\t%d\t\t\t%s\n",
                    student.getId(), student.getName(), student.getAge(), student.getAddress());
        }
    }

    public static void modify(ArrayList<Student> all) {
        Scanner scanner = new Scanner(System.in);
        Student stu;
        int index = -1;
        while (true) {
            System.out.println("输入修改学生的学号");
            int no = Integer.parseInt(scanner.nextLine());
            //查找元素
            stu = findStudent(no, all);
            index = findIndex(no, all);
            if (stu == null) {
                System.out.printf("未查找到学号为%d的学生\n", no);
            } else {
                break;
            }
        }

        System.out.println("请输入修改后的姓名");
        String name = scanner.nextLine();
        System.out.println("请输入修改后的年龄");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("请输入修稿后的住址");
        String address = scanner.nextLine();
        Student newStu = new Student(stu.getId(), name, age, address);
        all.set(index, newStu);
        System.out.println("修改成功!!");
    }

    public static void deleteStudent(ArrayList<Student> all) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入删除学生的学号");
        int no = scanner.nextInt();
        Student studentToDelete = findStudent(no, all);
        if (studentToDelete == null) {
            System.out.println("删除失败!未找到学号为" + no + "的学生!");
            return;
        }
        all.remove(studentToDelete);
        System.out.println("删除成功!");
    }

    private static Student findStudent(int no, ArrayList<Student> all) {
        Student stu = null;
        for (Student s : all) {
            if (s.getId() == no) {
                stu = s;
                break;
            }
        }
        return stu;
    }

    private static int findIndex(int no, ArrayList<Student> all) {
        int index = -1;
        for (int i = 0; i < all.size(); i++) {
            Student s = all.get(i);
            if (s.getId() == no) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static void addStudent(ArrayList<Student> all) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入学生的学号");
        int no = 0;
        try {
            no = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        int index;
        while (true) {
            index = findIndex(no, all);
            if (index != -1) {
                System.out.println("学号重复! 请重新输入");
            } else {
                break;
            }
        }

        System.out.println("输入学生姓名");
        String name = scanner.nextLine();

        System.out.println("输入学生年龄");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.println("输入学生住址");
        String address = scanner.nextLine();

        all.add(new Student(no, name, age, address));
    }
}
