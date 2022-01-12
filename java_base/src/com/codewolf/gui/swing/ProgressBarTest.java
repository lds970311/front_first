// Author : evan lee
// Time ： 2022-01-12  1:12
// FILENAME : ProgressBarTest.java
// STATEMENT: 

package com.codewolf.gui.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProgressBarTest {
    private final JFrame frame = new JFrame("进度条");
    private final JProgressBar progressBar = new JProgressBar(JProgressBar.HORIZONTAL);//进度条
    private final JCheckBox progress = new JCheckBox("不确定进度");
    private final JCheckBox border = new JCheckBox("不绘制边框");

    private void addListener() {
        progress.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean selected = progress.isSelected();
                progressBar.setIndeterminate(!selected);
            }
        });

        border.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean selected = border.isSelected();
                progressBar.setBorderPainted(!selected);
            }
        });
    }

    public void initView() {
        Box verticalBox = Box.createVerticalBox();
        verticalBox.add(progress);
        verticalBox.add(border);
        verticalBox.setPreferredSize(new Dimension(100, 150));
        verticalBox.setLocation(50, 75);
        frame.add(verticalBox, BorderLayout.WEST);
        progressBar.setValue(65);
        progressBar.setPreferredSize(new Dimension(200, 50));
        progressBar.setMaximum(0);
        progressBar.setMaximum(100);
        progressBar.setStringPainted(true);
        this.addListener();
        frame.add(progressBar);
        frame.setBounds(200, 200, 400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        for (int i = 0; i < 100; i++) {
            progressBar.setValue(i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new ProgressBarTest().initView();
    }
}
