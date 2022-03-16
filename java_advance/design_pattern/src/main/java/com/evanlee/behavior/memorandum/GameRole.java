// Author : evan lee
// Time ： 2022-03-14  21:51
// FILENAME : GameRole.java
// STATEMENT: 

package com.evanlee.behavior.memorandum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//游戏角色类
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameRole {
    private int health; //生命力
    private int attack; //攻击力
    private int defence; //防御力

    //初始化状态
    public void initState() {
        this.health = 100;
        this.attack = 100;
        this.defence = 100;
    }

    //战斗
    public void fight() {
        this.defence = 0;
        this.health = 0;
        this.attack = 0;
    }

    //保存角色状态
    public RoleStateMemento saveRoleState() {
        return new RoleStateMemento(this.health, this.attack, this.defence);
    }

    //回复角色状态
    public void recoverRoleState(RoleStateMemento roleStateMemento) {
        this.health = roleStateMemento.getHealth();
        this.attack = roleStateMemento.getAttack();
        this.defence = roleStateMemento.getDefence();
    }

    public void stateDisplay() {
        System.out.println("角色生命力：" + health);
        System.out.println("角色攻击力：" + attack);
        System.out.println("角色防御力：" + defence);
    }
}
