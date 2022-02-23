// Author : evan lee
// Time ： 2022-02-21  21:56
// FILENAME : SegateDisk.java
// STATEMENT: 

package com.evanlee.principle.dependencyInversion;

import java.util.ArrayList;
import java.util.List;

/**
 * 希捷硬盘
 */
public class SegateDisk implements Disk {
    private final List<String> data;

    public SegateDisk() {
        this.data = new ArrayList<>();
    }

    //存储数据
    public void saveData(String data) {
        this.data.add(data);
    }

    //读取数据
    public String getData(Integer index) {
        return this.data.get(index);
    }
}
