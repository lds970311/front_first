// Author : evan lee
// Time ： 2022-01-11  23:53
// FILENAME : SplitPaneTest.java
// STATEMENT: 

package com.codewolf.gui.swing;

import lombok.Data;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

@Data
class Book {

    private String name;

    private Icon icon;

    private String desc;

    public Book(String name, Icon icon, String desc) {
        this.name = name;
        this.icon = icon;
        this.desc = desc;
    }


    @Override
    public String toString() {
        return name;
    }
}

public class SplitPaneTest {
    Book[] books = {
            new Book("java自学宝典", new ImageIcon("F:\\Java\\front_first\\java_base\\resource\\img\\java.png"), "国内关于 Java 编程最全面的图书 \n 看得懂 ， 学得会"),

            new Book("轻量级的JAVAEE企业应用实战", new ImageIcon("F:\\Java\\front_first\\java_base\\resource\\img\\ee.png"), "SSM整合开发的经典图书，值的拥有"),

            new Book("Android基础教程", new ImageIcon("F:\\Java\\front_first\\java_base\\resource\\img\\android.png"), "全面介绍Android平台应用程序\n 开发的各方面知识"),
            new Book("jQuery基础教程", new ImageIcon("F:\\Java\\front_first\\java_base\\resource\\img\\jQuery.png"), "全面介绍jQuery\n 开发的各方面知识")

    };

    JFrame jf = new JFrame("测试JSplitPane");

    //声明程序中用到的组件
    JList<Book> bookJList = new JList<>(books);

    JLabel bookCover = new JLabel();

    JTextArea bookDesc = new JTextArea();

    public void init() {
        //组装视图
        //设定组件大小
        bookJList.setPreferredSize(new Dimension(150, 400));
        bookCover.setPreferredSize(new Dimension(220, 270));
        bookDesc.setPreferredSize(new Dimension(220, 130));

        //为jList设置条目选中监听器
        bookJList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                //获取当前选中的是哪个条目
                Book book = bookJList.getSelectedValue();
                //把书籍的图片用bookCover展示
                bookCover.setIcon(book.getIcon());

                //把书籍的描述用bookDesc展示
                bookDesc.setText(book.getDesc());
            }
        });


        //组装左边区域
        JSplitPane left = new JSplitPane(JSplitPane.VERTICAL_SPLIT, bookCover, new JScrollPane(bookDesc));

        left.setOneTouchExpandable(true);


        //组装整体
        JSplitPane hole = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, left, bookJList);

        //支持连续布局
        hole.setContinuousLayout(true);
        hole.setDividerSize(10);

        jf.add(hole);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);

    }

    public static void main(String[] args) {
        new SplitPaneTest().init();
    }
}
