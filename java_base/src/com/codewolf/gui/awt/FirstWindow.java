// Author : evan lee
// Time ： 2022-01-10  16:59
// FILENAME : FirstWindow.java
// STATEMENT: 第一个窗口

package com.codewolf.gui.awt;

import java.awt.*;

public class FirstWindow {
    public static void main(String[] args) {
        //需要配置: -Dfile.encoding=gbk
        Frame frame = new Frame("窗口A");
        Panel panel = new Panel();
        panel.add(new TextField("input your name"));
        panel.add(new Button("提交!"));
        frame.add(panel);
        frame.setBounds(200, 200, 500, 300);
        frame.setVisible(true);
    }
}
