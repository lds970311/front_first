// Author : evan lee
// Time ： 2022-02-28  15:30
// FILENAME : Student.java
// STATEMENT: 

package com.evanlee.construct.prototypemode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable {
    private String name;
    private String address;
}
