// Author : evan lee
// Time ： 2022-03-14  23:44
// FILENAME : Value.java
// STATEMENT: 

package com.evanlee.behavior.interpretor;

//终结符表达式角色
public class Value extends AbstractExpression {
    private int value;

    public Value(int value) {
        this.value = value;
    }


    @Override
    public int interpret(Context context) {
        return value;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}
