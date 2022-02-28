// Author : evan lee
// Time ： 2022-02-28  14:45
// FILENAME : Realizetype.java
// STATEMENT: 

package com.evanlee.construct.prototypemode;

public class Realizetype implements Cloneable {

    public Realizetype() {
        System.out.println("具体的原型对象创建完成！");
    }


    @Override
    public Realizetype clone() throws CloneNotSupportedException {
        System.out.println("具体原型复制成功！");
        return (Realizetype) super.clone();
    }
}
