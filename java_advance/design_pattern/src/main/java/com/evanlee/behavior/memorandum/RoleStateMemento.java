// Author : evan lee
// Time ： 2022-03-14  21:52
// FILENAME : RoleStateMemento.java
// STATEMENT: 

package com.evanlee.behavior.memorandum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//游戏状态存储类(备忘录类)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleStateMemento {
    private int health; //生命力
    private int attack; //攻击力
    private int defence; //防御力
}
