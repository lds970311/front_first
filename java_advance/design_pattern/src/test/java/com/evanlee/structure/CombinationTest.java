// Author : evan lee
// Time ： 2022-03-05  18:54
// FILENAME : CombinationTest.java
// STATEMENT: 

package com.evanlee.structure;

import com.evanlee.structure.combination.Menu;
import com.evanlee.structure.combination.MenuItem;
import org.junit.jupiter.api.Test;

public class CombinationTest {
    @Test
    void menuTest() {
        //创建菜单树
        Menu menu = new Menu("系统管理", 1);

        Menu menu1 = new Menu("菜单管理", 2);
        Menu menu2 = new Menu("权限管理", 2);
        Menu menu3 = new Menu("角色管理", 2);

        menu1.addMenu(new MenuItem("页面访问", 3));
        menu1.addMenu(new MenuItem("展开菜单", 3));
        menu1.addMenu(new MenuItem("编辑菜单", 3));
        menu1.addMenu(new MenuItem("删除菜单", 3));
        menu1.addMenu(new MenuItem("新增菜单", 3));

        menu2.addMenu(new MenuItem("页面访问", 3));
        menu2.addMenu(new MenuItem("提交保存", 3));

        menu3.addMenu(new MenuItem("页面访问", 3));
        menu3.addMenu(new MenuItem("新增角色", 3));
        menu3.addMenu(new MenuItem("修改角色", 3));

        menu.addMenu(menu1);
        menu.addMenu(menu2);
        menu.addMenu(menu3);

        menu.printMenus();
    }
}
