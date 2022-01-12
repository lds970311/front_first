// Author : evan lee
// Time ： 2022-01-11  22:43
// FILENAME : Chooser.java
// STATEMENT: 颜色/文件选择器

package com.codewolf.gui.swing;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Chooser {

    //颜色选择器
    private static class JColorChooserDemo {

        JFrame jFrame = new JFrame("测试颜色选择器");

        JTextArea jta = new JTextArea("我爱中华", 6, 30);

        JButton button = new JButton(new AbstractAction("改变文本框的本景色") {
            @Override
            public void actionPerformed(ActionEvent e) {
                //弹出颜色选择器
                Color result = JColorChooser.showDialog(jFrame, "颜色选择器", Color.WHITE);
                jta.setBackground(result);
            }
        });

        public void init() {
            jFrame.add(jta);

            jFrame.add(button, BorderLayout.SOUTH);

            jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jFrame.pack();
            jFrame.setVisible(true);
        }
    }

    //文件选择器
    private static class JFileChooserDemo {

        //创建窗口对象
        JFrame jf = new JFrame("测试JFileChooser");

        //创建打开文件对话框
        JFileChooser chooser = new JFileChooser(".");

        //创建菜单条
        JMenuBar jmb = new JMenuBar();
        //创建菜单
        JMenu jMenu = new JMenu("文件");
        //创建菜单项
        JMenuItem open = new JMenuItem(new AbstractAction("打开") {

            @Override
            public void actionPerformed(ActionEvent e) {
                chooser.showOpenDialog(jf);
                File imageFile = chooser.getSelectedFile();
                try {
                    image = ImageIO.read(imageFile);
                    drawArea.repaint();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        JMenuItem save = new JMenuItem(new AbstractAction("另存为") {

            @Override
            public void actionPerformed(ActionEvent e) {
                chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                chooser.showSaveDialog(jf);
                File dir = chooser.getSelectedFile();
                try {
                    ImageIO.write(image, "jpeg", new File(dir, "a.jpg"));
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        //用来记录用户选择的图片
        BufferedImage image;

        //显示图片
        class MyCanvas extends JPanel {
            @Override
            public void paint(Graphics g) {
                if (image != null) {
                    g.drawImage(image, 0, 0, null);
                }
            }
        }

        JPanel drawArea = new MyCanvas();

        public void init() {
            //设置图片显示区域大小
            drawArea.setPreferredSize(new Dimension(500, 300));
            jf.add(drawArea);

            //组装并设置菜单条
            jMenu.add(open);
            jMenu.add(save);
            jmb.add(jMenu);
            jf.setJMenuBar(jmb);

            //显示jf
            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jf.pack();
            jf.setVisible(true);
        }
    }

    public static void main(String[] args) {
        new JColorChooserDemo().init();
    }
}
