// Author : evan lee
// Time ： 2022-01-10  18:36
// FILENAME : Layouts.java
// STATEMENT: 布局容器

package com.codewolf.gui.awt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Layouts {
    public static void initWindow(Frame frame) {
        frame.setBounds(200, 200, 600, 400);
        frame.setVisible(true);
    }

    public static void flowLayout() {
        Frame frame = new Frame();
        frame.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
        for (int i = 0; i < 50; i++) {
            frame.add(new Button("按钮" + i));
        }
        //设置最佳大小
        frame.pack();
        initWindow(frame);
    }

    public static void borderLayout() {
        //1.创建Frame对象
        Frame frame = new Frame("这里测试BorderLayout");
        //2.指定Frame对象的布局管理器为BorderLayout
        frame.setLayout(new BorderLayout(30, 5));
        //3.往Frame指定东南西北中各添加一个按钮组件
        frame.add(new Button("东侧按钮"), BorderLayout.EAST);
        frame.add(new Button("西侧按钮"), BorderLayout.WEST);
        frame.add(new Button("南侧按钮"), BorderLayout.SOUTH);
        frame.add(new Button("北侧按钮"), BorderLayout.NORTH);
        frame.add(new Button("中间按钮"), BorderLayout.CENTER);
        //4.设置Frame为最佳大小
        frame.pack();
        //5.设置Frame可见
        frame.setVisible(true);
    }

    public static void gridLayout() {
        //1.创建Frame对象，并且标题设置为计算器
        Frame frame = new Frame("计算器");

        //2.创建一个Panel对象，并且往Panel中放置一个TextField组件
        Panel p1 = new Panel();
        p1.add(new TextField(30));

        //3.把上述的Panel放入到Frame的北侧区域
        frame.add(p1, BorderLayout.NORTH);

        //4.创建一个Panel对象，并且设置其布局管理器为GridLayout
        Panel p2 = new Panel();
        p2.setLayout(new GridLayout(3, 5, 4, 4));

        //5.往上述Panel中，放置15个按钮，内容依次是：0,1,2,3,4,5,6，7,8,9，+，-，*，/,.
        for (int i = 0; i < 10; i++) {
            p2.add(new Button(i + ""));
        }
        p2.add(new Button("+"));
        p2.add(new Button("-"));
        p2.add(new Button("*"));
        p2.add(new Button("/"));
        p2.add(new Button("."));

        //6.把上述Panel添加到Frame的中间区域中国
        frame.add(p2);
        //7.设置Frame为最佳大小
        frame.pack();

        //8.设置Frame可见
        frame.setVisible(true);
    }

    public static void addComponent(Container container, Component c, GridBagLayout gridBagLayout, GridBagConstraints gridBagConstraints) {
        gridBagLayout.setConstraints(c, gridBagConstraints);
        container.add(c);
    }

    public static void gridBagLayout() {
        //1.创建Frame对象
        Frame frame = new Frame("这里是GridBagLayout测试");

        //2.创建GridBagLayout对象
        GridBagLayout gbl = new GridBagLayout();

        //3.把Frame对象的布局管理器设置为GridBagLayout
        frame.setLayout(gbl);

        //4.创建GridBagConstraints对象
        GridBagConstraints gbc = new GridBagConstraints();

        //5.创建容量为10的Button数组
        Button[] bs = new Button[10];

        //6.遍历数组，初始化每一个Button
        for (int i = 0; i < bs.length; i++) {
            bs[i] = new Button("按钮" + (i + 1));
        }

        //7.设置所有的GridBagConstraints对象的fill属性为GridBagConstraints.BOTH,当有空白区域时，组件自动扩大占满空白区域
        gbc.fill = GridBagConstraints.BOTH;

        //8.设置GridBagConstraints对象的weightx设置为1,表示横向扩展比例为1
        gbc.weightx = 1;

        //9.往frame中添加数组中的前3个Button
        addComponent(frame, bs[0], gbl, gbc);
        addComponent(frame, bs[1], gbl, gbc);
        addComponent(frame, bs[2], gbl, gbc);

        //10.把GridBagConstraints的gridwidth设置为GridBagConstraints.REMAINDER,则表明当前组件是横向最后一个组件
        gbc.gridwidth = GridBagConstraints.REMAINDER;

        //11.把button数组中第四个按钮添加到frame中
        addComponent(frame, bs[3], gbl, gbc);


        //12.把GridBagConstraints的weighty设置为1，表示纵向扩展比例为1
        gbc.weighty = 1;

        //13.把button数组中第5个按钮添加到frame中
        addComponent(frame, bs[4], gbl, gbc);

        //14.把GridBagConstaints的gridheight和gridwidth设置为2，表示纵向和横向会占用两个网格
        gbc.gridheight = 2;
        gbc.gridwidth = 2;

        //15.把button数组中第6个按钮添加到frame中
        addComponent(frame, bs[5], gbl, gbc);

        //16.把GridBagConstaints的gridheight和gridwidth设置为1，表示纵向会占用1个网格
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        //17.把button数组中第7个按钮添加到frame中
        addComponent(frame, bs[6], gbl, gbc);

        //18.把GridBagConstraints的gridwidth设置为GridBagConstraints.REMAINDER,则表明当前组件是横向最后一个组件
        gbc.gridwidth = GridBagConstraints.REMAINDER;

        //19.把button数组中第8个按钮添加到frame中
        addComponent(frame, bs[7], gbl, gbc);

        //20.把GridBagConstaints的gridwidth设置为1，表示纵向会占用1个网格
        gbc.gridwidth = 1;

        //21.把button数组中第9、10个按钮添加到frame中
        addComponent(frame, bs[8], gbl, gbc);
        addComponent(frame, bs[9], gbl, gbc);

        //22.设置frame为最佳大小
        frame.pack();

        //23.设置frame可见
        frame.setVisible(true);
    }

    public static void cardLayout() {
        //1.创建Frame对象
        Frame frame = new Frame("这里测试CardLayout");

        //2.创建一个String数组，存储不同卡片的名字
        String[] names = {"第一张", "第二张", "第三张", "第四张", "第五张"};

        //3.创建一个Panel容器p1，并设置其布局管理器为CardLayout,用来存放多张卡片
        CardLayout cardLayout = new CardLayout();
        Panel p1 = new Panel();
        p1.setLayout(cardLayout);

        //4.往p1中存储5个Button按钮，名字从String数组中取
        for (int i = 0; i < 5; i++) {
            p1.add(names[i], new Button(names[i]));
        }

        //5.创建一个Panel容器p2,用来存储5个按钮，完成卡片的切换
        Panel p2 = new Panel();

        //6.创建5个按钮，并给按钮设置监听器
        ActionListener listener = e -> {
            String command = e.getActionCommand();
            switch (command) {
                case "上一张":
                    cardLayout.previous(p1);
                    break;
                case "下一张":
                    cardLayout.next(p1);
                    break;
                case "第一张":
                    cardLayout.first(p1);
                    break;
                case "最后一张":
                    cardLayout.last(p1);
                    break;
                case "第三张":
                    cardLayout.show(p1, "第三张");
                    break;
            }
        };

        Button b1 = new Button("上一张");
        Button b2 = new Button("下一张");
        Button b3 = new Button("第一张");
        Button b4 = new Button("最后一张");
        Button b5 = new Button("第三张");
        b1.addActionListener(listener);
        b2.addActionListener(listener);
        b3.addActionListener(listener);
        b4.addActionListener(listener);
        b5.addActionListener(listener);

        //7.把5个按钮添加到p2中
        p2.add(b1);
        p2.add(b2);
        p2.add(b3);
        p2.add(b4);
        p2.add(b5);


        //8.把p1添加到frame的中间区域
        frame.add(p1);


        //9.把p2添加到frame的底部区域
        frame.add(p2, BorderLayout.SOUTH);

        //10设置frame最佳大小并可见
        frame.pack();
        frame.setVisible(true);
    }

    public static void boxLayout() {
        //1.创建Frame对象
        Frame frame = new Frame("这里测试BoxLayout");

        //2.创建一个横向的Box,并添加两个按钮
        Box hBox = Box.createHorizontalBox();
        hBox.add(new Button("水平按钮一"));
        hBox.add(new Button("水平按钮二"));

        //3.创建一个纵向的Box，并添加两个按钮
        Box vBox = Box.createVerticalBox();
        vBox.add(new Button("垂直按钮一"));
        vBox.add(new Button("垂直按钮二"));

        //4.把box容器添加到frame容器中
        frame.add(hBox, BorderLayout.NORTH);
        frame.add(vBox);


        //5.设置frame最佳大小并可见

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        boxLayout();
    }
}
