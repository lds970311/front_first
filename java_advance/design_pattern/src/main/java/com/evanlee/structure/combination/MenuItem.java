// Author : evan lee
// Time ： 2022-03-05  18:51
// FILENAME : MenuItem.java
// STATEMENT: 

package com.evanlee.structure.combination;

//菜单项类(叶子节点)
public class MenuItem extends MenuComponent {

    public MenuItem(String menuName, int level) {
        this.MenuName = menuName;
        this.level = level;
    }

    @Override
    public void printMenus() {
        for (int i = 0; i < this.level; i++) {
            System.out.print("--");
        }
        System.out.println(this.MenuName);
    }
}
