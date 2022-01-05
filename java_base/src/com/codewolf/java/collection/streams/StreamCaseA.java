// Author : evan lee
// Time ： 2022-01-05  23:31
// FILENAME : StreamCaseA.java

/*需求：某个公司的开发部门，分为开发一部和二部，现在需要进行年中数据结算。
分析：
：员工信息至少包含了(名称、性别、工资、奖金、处罚记录)
：开发一部有4个员工、开发二部有5名员工
：分别筛选出2个部门的最高工资的员工信息，封装成优秀员工对象Topperformer
：分别统计出2个部门的平均月收入，要求去掉最高和最低工资。
：统计2个开发部门整体的平均工资，去掉最低和最高工资的平均值。

 *
 */

package com.codewolf.java.collection.streams;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

enum Gender {
    Female,
    Male
}

class Employee {
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private Gender gender;
    @Getter
    @Setter
    private double salary;
    @Getter
    @Setter
    private double bonus;
    @Getter
    @Setter
    private String punish; // 处罚信息

    public Employee() {
    }

    public Employee(String name, Gender gender, double salary, double bonus, String punish) {
        this.name = name;
        this.gender = gender;
        this.salary = salary;
        this.bonus = bonus;
        this.punish = punish;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", salary=" + salary +
                ", bonus=" + bonus +
                ", punish='" + punish + '\'' +
                '}';
    }
}

public class StreamCaseA {
    private static double allMoney = 0;

    public static void main(String[] args) {
        List<Employee> one = new ArrayList<>();
        one.add(new Employee("猪八戒", Gender.Male, 30000, 25000, null));
        one.add(new Employee("孙悟空", Gender.Male, 25000, 1000, "顶撞上司"));
        one.add(new Employee("沙僧", Gender.Male, 20000, 20000, null));
        one.add(new Employee("小白龙", Gender.Male, 20000, 25000, null));

        List<Employee> two = new ArrayList<>();
        two.add(new Employee("武松", Gender.Male, 15000, 9000, null));
        two.add(new Employee("李逵", Gender.Male, 20000, 10000, null));
        two.add(new Employee("西门庆", Gender.Male, 50000, 100000, "被打"));
        two.add(new Employee("潘金莲", Gender.Male, 3500, 1000, "被打"));
        two.add(new Employee("武大郎", Gender.Male, 20000, 0, "下毒"));

        //分别筛选出2个部门的最高工资的员工信息，封装成优秀员工对象Topperformer
        Employee employee1 = one.stream().max((o1, o2) -> (int) (o1.getSalary() - o2.getSalary())).get();

        Employee employee2 = two.stream().max((o1, o2) -> (int) (o1.getSalary() - o2.getSalary())).get();
        System.out.println(employee1);
        System.out.println(employee2);
        //分别统计出2个部门的平均月收入，要求去掉最高和最低工资。

        //统计2个开发部门整体的平均工资，去掉最低和最高工资的平均值。
        Stream<Employee> s1 = one.stream();
        Stream<Employee> s2 = two.stream();
        Stream<Employee> s3 = Stream.concat(s2, s1);

        s3
                .sorted((o1, o2) -> Double.compare(o1.getSalary(), o2.getSalary()))
                .skip(1)
                .limit(one.size() + two.size() - 2)
                .forEach(o -> allMoney += o.getSalary());
        System.out.println("avg salary: " + allMoney / 9);
    }
}
