// Author : evan lee
// Time ： 2022-01-10  20:41
// FILENAME : Listener.java
// STATEMENT: 事件处理

package com.codewolf.gui.awt;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Listener {
    public static void actionEvent() {
        Frame frame = new Frame();
        frame.setBounds(200, 200, 600, 400);
        //设置监听去
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //点击x时候的逻辑
                System.exit(0);
            }
        });
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        actionEvent();
    }
}
