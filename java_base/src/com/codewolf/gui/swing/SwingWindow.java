// Author : evan lee
// Time ： 2022-01-11  20:19
// FILENAME : SwingWindow.java
// STATEMENT: swing的第一个窗口

package com.codewolf.gui.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingWindow {
    private final JFrame window = new JFrame("swing基本组件");
    //菜单相关
    JMenuBar menuBar = new JMenuBar();
    //文本域
    private final JTextArea textArea = new JTextArea(8, 20);
    //列表框
    //定义一个数组存储颜色
    String[] colors = {"红色", "绿色 ", "蓝色 "};
    private final JList<String> colorList = new JList<>(colors);
    //选择组件
    private final JComboBox<String> colorChooser = new JComboBox<>();
    private final ButtonGroup genderGroup = new ButtonGroup();
    private final JCheckBox isMarried = new JCheckBox("是否已婚?", true);
    //底部
    private final JTextField textField = new JTextField(40);
    private final JButton btn = new JButton("确定", new ImageIcon("F:\\Java\\front_first\\java_base\\resource\\img\\ok.png"));
    //定义一个ButtongGroup对象，用于组合风格按钮，形成单选
    private final ButtonGroup flavorgroup = new ButtonGroup();
    //右键菜单
    private final JPopupMenu favourGroup = new JPopupMenu(); //单选菜单

    /**
     * 创建菜单
     */
    private void createMenu() {
        JMenu file = new JMenu("文件");
        JMenu edit = new JMenu("编辑");
        JMenuItem newline = new JMenuItem("自动换行");
        JMenuItem line = new JMenuItem("-");
        JMenuItem copy = new JMenuItem("复制", new ImageIcon("F:\\Java\\front_first\\java_base\\resource\\img\\copy.png"));
        JMenuItem paste = new JMenuItem("粘贴", new ImageIcon("F:\\Java\\front_first\\java_base\\resource\\img\\paste.png"));
        JMenu format = new JMenu("格式");
        JMenuItem zhushi = new JMenuItem("注释");
        JMenuItem quxiaozhushi = new JMenuItem("取消注释");
        format.add(zhushi);
        format.add(quxiaozhushi);
        edit.add(newline);
        edit.add(copy);
        edit.add(paste);
        edit.add(format);
        menuBar.add(file);
        menuBar.add(edit);
    }

    private void createPopupMenu() {
        JRadioButtonMenuItem metalItem = new JRadioButtonMenuItem("Metal 风格", true);
        JRadioButtonMenuItem nimbusItem = new JRadioButtonMenuItem("Nimbus 风格", true);
        JRadioButtonMenuItem windowsItem = new JRadioButtonMenuItem("Windows 风格", true);
        JRadioButtonMenuItem classicItem = new JRadioButtonMenuItem("Windows 经典风格", true);
        JRadioButtonMenuItem motifItem = new JRadioButtonMenuItem("Motif 风格", true);
        //给5个风格菜单创建事件监听器
        ActionListener flavorLister = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();
                try {
                    changeFlavor(command);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        };


        //为5个风格菜单项注册监听器
        metalItem.addActionListener(flavorLister);
        nimbusItem.addActionListener(flavorLister);
        windowsItem.addActionListener(flavorLister);
        classicItem.addActionListener(flavorLister);
        motifItem.addActionListener(flavorLister);
        this.flavorgroup.add(metalItem);
        this.favourGroup.add(nimbusItem);
        this.favourGroup.add(windowsItem);
        this.favourGroup.add(classicItem);
        this.favourGroup.add(motifItem);
        textArea.setComponentPopupMenu(favourGroup);
    }

    //定义一个方法，用于改变界面风格
    private void changeFlavor(String command) throws Exception {
        switch (command) {
            case "Metal 风格":
                UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                break;
            case "Nimbus 风格":
                UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
                break;
            case "Windows 风格":
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
                break;
            case "Windows 经典风格":
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
                break;
            case "Motif 风格":
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
                break;
        }

        //更新f窗口内顶级容器以及所有组件的UI
        SwingUtilities.updateComponentTreeUI(window.getContentPane());
        //更新mb菜单条及每部所有组件UI
        SwingUtilities.updateComponentTreeUI(menuBar);
        //更新右键菜单及内部所有菜单项的UI
        SwingUtilities.updateComponentTreeUI(favourGroup);
    }

    private void initColorChooser() {
        this.colorChooser.addItem("红色");
        this.colorChooser.addItem("蓝色");
        this.colorChooser.addItem("黑色");
    }


    private void initButtonGroup(JPanel selectPanel) {
        JRadioButton male = new JRadioButton("男", false);
        JRadioButton female = new JRadioButton("女", true);
        this.genderGroup.add(female);
        this.genderGroup.add(male);
        selectPanel.add(male);
        selectPanel.add(female);
    }

    public void initView() {
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(textField);
        bottomPanel.add(btn);
        this.window.add(bottomPanel, BorderLayout.SOUTH);
        //组装选择组件
        JPanel selectPanel = new JPanel();
        selectPanel.add(colorChooser);
        this.initButtonGroup(selectPanel);
        selectPanel.add(isMarried);
        this.initColorChooser();
        //组装文本域和选择相关组件
        Box topLeft = Box.createVerticalBox();
        topLeft.add(textArea);
        topLeft.add(selectPanel);
        //组装顶部
        Box top = Box.createHorizontalBox();
        top.add(topLeft);
        top.add(colorList);
        this.window.add(top);
        this.createMenu();
        this.createPopupMenu();
        this.window.setJMenuBar(menuBar);
        this.window.setBounds(200, 200, 800, 500);
        this.window.pack();
        this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.window.setVisible(true);
    }


    public static void main(String[] args) {
        new SwingWindow().initView();
    }
}
