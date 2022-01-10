// Author : evan lee
// Time ： 2022-01-11  3:05
// FILENAME : BallGame.java
// STATEMENT: awt弹球游戏

package com.codewolf.gui.awt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.EventListener;

public class BallGame {
    //桌面宽度
    private final int TABLE_WIDTH = 300;
    //桌面高度
    private final int TABLE_HEIGHT = 400;


    //球拍的高度和宽度
    private final int RACKET_WIDTH = 60;
    private final int RACKET_HEIGHT = 20;

    //小球的大小
    private final int BALL_SIZE = 16;

    //定义小球纵向运行速度
    private int ySpeed = 5;
    //小球横向运行速度
    private int xSpeed = 2;

    //定义小球的初始坐标
    private int ballX = 120;
    private int ballY = 20;

    //定义球拍的初始坐标，x坐标会发生变化，y坐标不会发生变化
    private int RACKET_X = 120;
    private final int RACKET_Y = 340;

    //声明定时器
    private Timer timer;

    //定义游戏结束的标记
    private boolean isLose = false;

    //声明一个桌面
    private final MyCanvas tableArea = new MyCanvas();

    //创建窗口对象
    private final Frame frame = new Frame("弹球游戏");
    private Integer totalScore = 0;

    private class MyCanvas extends Canvas {
        //重写paint方法，实现绘图
        @Override
        public void paint(Graphics g) {
            //判断游戏是否结束
            if (isLose) {//结束
                g.setColor(Color.RED);
                g.setFont(new Font("Times", Font.BOLD, 30));
                g.drawString("游戏结束！", TABLE_WIDTH / 2 - (30 * 5) / 2, TABLE_HEIGHT / 2);
                g.drawString("分数为:" + totalScore, TABLE_WIDTH / 2 - (30 * 5) / 2, TABLE_HEIGHT / 2 + 50);
            } else {//没有结束

                //设置颜色并绘制小球
                g.setColor(Color.RED);
                g.fillOval(ballX, ballY, BALL_SIZE, BALL_SIZE);

                //设置颜色并绘制球拍
                g.setColor(Color.PINK);
                g.fillRect(RACKET_X, RACKET_Y, RACKET_WIDTH, RACKET_HEIGHT);

                //显示分数
                g.setColor(Color.RED);
                g.setFont(new Font("Times", Font.PLAIN, 14));
                g.drawString("当前得分" + totalScore, 200, 30);
            }
        }
    }

    /**
     * 用来监听小球的变化情况
     *
     * @return Action
     */
    private ActionListener createTask() {
        //定义ActionListener
        return e -> {
            //小球碰到左右边框
            if (ballX <= 0 || ballX >= TABLE_WIDTH - BALL_SIZE) {
                xSpeed = -xSpeed;
            }
            //小球的高度超出了球拍的位置，且横向不在球拍范围内，则游戏结束
            if (ballY > RACKET_Y && (ballX < RACKET_X || ballX > RACKET_X + RACKET_WIDTH)) {
                //结束定时器
                timer.stop();
                //把游戏结束的标记设置为true
                isLose = true;
                //重绘界面
                tableArea.repaint();

            }
            //如果小球横向在球拍范围内，且到达球拍位置或者到达顶端位置，则小球反弹
            if (ballY <= 0 || (ballY >= RACKET_Y - BALL_SIZE && ballX >= RACKET_X && ballX <= RACKET_X + RACKET_WIDTH)) {
                ySpeed = -ySpeed;
            }

            if (ballY >= RACKET_Y - BALL_SIZE && ballX >= RACKET_X && ballX <= RACKET_X + RACKET_WIDTH) {
                //碰到球拍加分
                this.totalScore += 10;
            }
            if (totalScore % 100 == 0 && totalScore != 0) {
                ySpeed *= 2;
                xSpeed *= 2;
            }

            //更新小球的坐标
            ballX += xSpeed;
            ballY += ySpeed;

            //重绘桌面
            tableArea.repaint();
        };
    }

    /**
     * /监听键盘 ←  → 按下操作，当指定的键按下时，球拍的水平坐标分别会增加或者减少
     *
     * @return 键盘事件监听
     */
    private EventListener watchKeyListener() {
        //定义键盘监听器
        return new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_LEFT) {//←
                    //没有到左边界，可以继续向左移动
                    if (RACKET_X > 0) {
                        RACKET_X -= 10;
                    }
                }

                if (keyCode == KeyEvent.VK_RIGHT) {//→
                    //没有到右边界，可以继续向右移动
                    if (RACKET_X < TABLE_WIDTH - RACKET_WIDTH) {
                        RACKET_X += 10;
                    }
                }
            }
        };
    }

    public void init() {
        //设置桌面区域的最佳大小
        tableArea.setPreferredSize(new Dimension(TABLE_WIDTH, TABLE_HEIGHT));
        //把桌面添加到frame中
        frame.add(tableArea);

        KeyListener keyListener = (KeyListener) this.watchKeyListener();
        //为窗口和tableArea分别添加键盘事件
        frame.addKeyListener(keyListener);
        tableArea.addKeyListener(keyListener);

        ActionListener timerTask = this.createTask();
        //设置定时器，定时任务就是timerTask
        timer = new Timer(50, timerTask);
        timer.start();

        //设置frame最佳大小，并可视
        this.frame.setBounds(200, 200, 600, 400);
        this.frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.frame.pack();
        this.frame.setVisible(true);
    }

    public static void main(String[] args) {
        new BallGame().init();
    }
}
