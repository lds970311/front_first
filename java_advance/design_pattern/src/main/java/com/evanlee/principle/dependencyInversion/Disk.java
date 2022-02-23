// Author : evan lee
// Time ： 2022-02-21  22:26
// FILENAME : Disk.java
// STATEMENT: 

package com.evanlee.principle.dependencyInversion;

public interface Disk {
    void saveData(String data);

    String getData(Integer index);
}
