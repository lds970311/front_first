// Author : evan lee
// Time ： 2022-01-12  1:12
// FILENAME : ProgressBarTest.java
// STATEMENT: 

package com.codewolf.gui.swing;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProgressBarTest {
    private final JFrame frame = new JFrame("进度条");
    private final JProgressBar progressBar = new JProgressBar(JProgressBar.HORIZONTAL);//进度条
    private final JCheckBox progress = new JCheckBox("不确定进度");
    private final JCheckBox border = new JCheckBox("不绘制边框");

    private static class ProgressThread implements Runnable {
        @Getter
        private volatile Integer currentVal = 0;
        @Getter
        private Integer totalVal;

        public ProgressThread(Integer totalVal) {
            this.totalVal = totalVal;
        }

        @Override
        public void run() {
            while (true) {
                if (currentVal < totalVal) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    currentVal++;
                } else {
                    break;
                }
            }
        }
    }

    private ProgressThread task;

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
        frame.setVisible(true);
        //启动进度条线程
        this.task = new ProgressThread(100);
        new Thread(this.task).start();
        //使用定时器轮训任务的完成比例,并显示在任务条上

        Timer progressTimer = new Timer(500, e -> {
            int percent = (int) (((double) task.getCurrentVal() / (double) task.getTotalVal()) * 100);
            System.out.println(percent);
            progressBar.setValue(percent);
        });

        progressTimer.start();
        progressBar.addChangeListener(e -> {
            if (progressBar.getValue() == 100) {
                progressTimer.stop();
            }
        });
    }

    public static void main(String[] args) {
        new ProgressBarTest().initView();
    }
}
