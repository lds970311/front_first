// Author : evan lee
// Time ： 2022-03-14  23:00
// FILENAME : MementoTest.java
// STATEMENT: 

package com.evanlee.behavior;

import com.evanlee.behavior.memorandum.GameRole;
import com.evanlee.behavior.memorandum.RoleStateCaretaker;
import org.junit.jupiter.api.Test;

public class MementoTest {
    @Test
    void memento() {
        System.out.println("------------大战Boss前------------");
        //大战Boss前
        GameRole gameRole = new GameRole();
        gameRole.initState();
        gameRole.stateDisplay();

        //保存进度
        RoleStateCaretaker roleStateCaretaker = new RoleStateCaretaker();
        roleStateCaretaker.setRoleStateMemento(gameRole.saveRoleState());

        System.out.println("------------大战Boss后------------");
        //大战Boss时，损耗严重
        gameRole.fight();
        gameRole.stateDisplay();
        System.out.println("------------恢复之前状态------------");
        //恢复之前状态
        gameRole.recoverRoleState((roleStateCaretaker.getRoleStateMemento()));
        gameRole.stateDisplay();

    }
}
