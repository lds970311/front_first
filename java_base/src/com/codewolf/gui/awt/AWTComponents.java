// Author : evan lee
// Time ： 2022-01-10  19:48
// FILENAME : AWTComponents.java
// STATEMENT: 

package com.codewolf.gui.awt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AWTComponents {
    public static void basicComponentDemo() {
        Frame frame = new Frame("这里测试基本组件");

        //定义一个按钮
        Button ok = new Button("确认");

        //定义一个复选框组
        CheckboxGroup cbg = new CheckboxGroup();
        //定义一个单选框，初始处于被选中状态,并添加到cbg组中
        Checkbox male = new Checkbox("男", cbg, true);

        //定义一个单选框，初始处于未被选中状态,并添加到cbg组中
        Checkbox female = new Checkbox("女", cbg, false);

        //定义一个复选框，初始处于未被选中状态
        Checkbox married = new Checkbox("是否已婚？", false);

        //定义一个下拉选择框
        Choice colorChooser = new Choice();

        //定义一个列表选择框
        List colorList = new List(6, true);

        //定义一个5行，20列的多行文本域
        TextArea ta = new TextArea(5, 20);

        //定义一个50列的单行文本域
        TextField tf = new TextField(50);


        //往下拉选择框中添加内容
        colorChooser.add("红色");
        colorChooser.add("绿色");
        colorChooser.add("蓝色");

        //往列表选择框中添加内容
        colorList.add("红色");
        colorList.add("绿色");
        colorList.add("蓝色");

        //创建一个装载按钮和文本框的Panel容器
        Panel bottom = new Panel();
        bottom.add(tf);
        bottom.add(ok);

        //把bottom添加到Frame的底部
        frame.add(bottom, BorderLayout.SOUTH);

        //创建一个Panel容器，装载下拉选择框，单选框和复选框
        Panel checkPanel = new Panel();
        checkPanel.add(colorChooser);
        checkPanel.add(male);
        checkPanel.add(female);
        checkPanel.add(married);

        //创建一个垂直排列的Box容器，装载 多行文本域和checkPanel
        Box topLeft = Box.createVerticalBox();
        topLeft.add(ta);
        topLeft.add(checkPanel);

        //创建一个水平排列的Box容器，装载topLeft和列表选择框
        Box top = Box.createHorizontalBox();
        top.add(topLeft);
        top.add(colorList);

        //将top添加到frame的中间区域
        frame.add(top);

        //设置frame最佳大小并可见
        frame.pack();
        frame.setVisible(true);
    }

    //文件对话框
    public static void dileDialog() {
        Frame frame = new Frame("这里测试FileDialog");

        FileDialog d1 = new FileDialog(frame, "选择需要加载的文件", FileDialog.LOAD);
        FileDialog d2 = new FileDialog(frame, "选择需要保存的文件", FileDialog.SAVE);

        Button b1 = new Button("打开文件");
        Button b2 = new Button("保存文件");

        //给按钮添加事件
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d1.setVisible(true);
                //打印用户选择的文件路径和名称
                System.out.println("用户选择的文件路径:" + d1.getDirectory());
                System.out.println("用户选择的文件名称:" + d1.getFile());
            }
        });

        System.out.println("-------------------------------");
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d2.setVisible(true);
                //打印用户选择的文件路径和名称
                System.out.println("用户选择的文件路径:" + d2.getDirectory());
                System.out.println("用户选择的文件名称:" + d2.getFile());
            }
        });

        //添加按钮到frame中

        frame.add(b1);
        frame.add(b2, BorderLayout.SOUTH);

        //设置frame最佳大小并可见
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        dileDialog();
    }
}
