// Author : evan lee
// Time ： 2022-03-14  23:46
// FILENAME : Context.java
// STATEMENT: 

package com.evanlee.behavior.interpretor;

import java.util.HashMap;
import java.util.Map;

//环境类
public class Context {
    private Map<Variable, Integer> map = new HashMap<>();

    public void assign(Variable var, Integer value) {
        map.put(var, value);
    }

    public int getValue(Variable var) {
        Integer value = map.get(var);
        return value;
    }
}
