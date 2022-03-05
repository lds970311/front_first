// Author : evan lee
// Time ： 2022-03-05  18:37
// FILENAME : MenuComponent.java
// STATEMENT: 

package com.evanlee.structure.combination;

//菜单组件  不管是菜单还是菜单项，都应该继承该类
public abstract class MenuComponent {
    protected String MenuName;
    protected int level; //菜单层级

    //添加子菜单
    public void addMenu(MenuComponent menu) {
        throw new UnsupportedOperationException();
    }

    //移除子菜单
    public void removeMenu(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    //获取指定的子菜单
    public MenuComponent getChild(int index) {
        throw new UnsupportedOperationException();
    }

    //获取菜单/菜单项的名称
    public String getMenuName() {
        return this.MenuName;
    }

    //打印菜单名称,包含 子菜单,子菜单项
    public abstract void printMenus();
}
