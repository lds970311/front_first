// Author : evan lee
// Time ： 2022-03-05  18:44
// FILENAME : Menu.java
// STATEMENT: 

package com.evanlee.structure.combination;

import java.util.ArrayList;
import java.util.List;

//菜单类
public class Menu extends MenuComponent {

    //菜单可以有多个子菜单,子菜单项
    private final List<MenuComponent> menuComponentList;

    public Menu(String menuName, int level) {
        this.MenuName = menuName;
        this.level = level;
        this.menuComponentList = new ArrayList<>();
    }

    @Override
    public void addMenu(MenuComponent menu) {
        this.menuComponentList.add(menu);
    }

    @Override
    public void removeMenu(MenuComponent menuComponent) {
        this.menuComponentList.remove(menuComponent);
    }

    @Override
    public MenuComponent getChild(int index) {
        return this.menuComponentList.get(index);
    }

    @Override
    public void printMenus() {
        for (int i = 0; i < this.level; i++) {
            System.out.print("--");
        }
        //打印菜单名称
        System.out.println(this.MenuName);

        //打印子菜单或菜单项名称
        for (MenuComponent menuComponent : this.menuComponentList) {
            menuComponent.printMenus();
        }
    }
}
