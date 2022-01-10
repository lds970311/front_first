// Author : evan lee
// Time ： 2022-01-10  20:47
// FILENAME : MenuComponents.java
// STATEMENT: 菜单组件

package com.codewolf.gui.awt;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MenuComponents {
    public static void createMenu() {
        Frame frame = new Frame();
        frame.setBounds(200, 200, 600, 400);
        Menu fileMenu = new Menu("文件");
        Menu edit = new Menu("编辑");
        //主菜单
        MenuBar menuBar = new MenuBar();
        menuBar.add(fileMenu);
        menuBar.add(edit);
        //编辑菜单中添加菜单项
        edit.add(new MenuItem("自动换行"));
        edit.add(new MenuItem("粘贴"));
        edit.add(new MenuItem("复制"));
        edit.add(new MenuItem("-"));
        //创建一个二级菜单
        Menu pattern = new Menu("格式");
        pattern.add(new MenuItem("注释 Ctrl+Shift+Q", new MenuShortcut(KeyEvent.VK_Q, true)));
        pattern.add(new MenuItem("取消注释"));
//        二级菜单加入主菜单的菜单项
        edit.add(pattern);
        //菜单加入窗口
        frame.setMenuBar(menuBar);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        createMenu();
    }
}
