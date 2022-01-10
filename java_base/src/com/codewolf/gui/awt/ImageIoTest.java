// Author : evan lee
// Time ： 2022-01-11  5:13
// FILENAME : ImageIo.java
// STATEMENT:编写图片查看程序,支持另存操作

package com.codewolf.gui.awt;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageIoTest {
    private final Frame window = new Frame();

    private BufferedImage image;

    public static final int WIDTH = 600;
    public static final int HEIGHT = 400;

    private class MyCanvas extends Canvas {
        @Override
        public void paint(Graphics g) {
            if (image != null) {
                g.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null);
            }
        }
    }

    private MyCanvas canvas = new MyCanvas();


    private void addMenu() {
        MenuBar bar = new MenuBar();
        Menu menu = new Menu("文件");
        MenuItem open = new MenuItem("打开");
        this.addOpenListener(open);
        MenuItem save = new MenuItem("另存为");
        this.addSaveListener(save);
        menu.add(open);
        menu.add(save);
        bar.add(menu);
        window.setMenuBar(bar);
    }

    private void addOpenListener(MenuItem save) {
        save.addActionListener(e -> {
            //弹出对话框，选择本地图片
            FileDialog oDialog = new FileDialog(window);
            oDialog.setVisible(true);
            //读取用户选择的图片
            String dir = oDialog.getDirectory();
            String file = oDialog.getFile();
            try {
                image = ImageIO.read(new File(dir, file));

                canvas.repaint();

            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
    }

    private void addSaveListener(MenuItem open) {
        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //弹出对话框，另存为
                FileDialog sDialog = new FileDialog(window, "保存图片", FileDialog.SAVE);
                sDialog.setVisible(true);
                String dir = sDialog.getDirectory();
                String file = sDialog.getFile();

                try {
                    ImageIO.write(image, "JPEG", new File(dir, file));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    public void initView() {
        //设置菜单项
        this.addMenu();
        //添加canvas
        this.window.add(canvas);
        this.window.pack();
        this.window.setBounds(200, 200, WIDTH, HEIGHT);
        this.window.setVisible(true);
        this.window.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        new ImageIoTest().initView();
    }
}
