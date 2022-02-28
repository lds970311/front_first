// Author : evan lee
// Time ： 2022-02-28  15:30
// FILENAME : Citation.java
// STATEMENT: 

package com.evanlee.construct.prototypemode;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Citation implements Cloneable, Serializable {

    private Student stu;

    @Override
    public Citation clone() throws CloneNotSupportedException {
        return (Citation) super.clone();
    }

    public void show() {
        System.out.println(stu.getName() + "同学：在2020学年第一学期中表现优秀，被评为三好学生。特发此状！");
    }
}
