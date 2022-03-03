// Author : evan lee
// Time ： 2022-03-03  14:01
// FILENAME : RMVBFile.java
// STATEMENT: 

package com.evanlee.structure.bridging;

public class RMVBFile implements VideoFile {

    @Override
    public void decode(String fileName) {
        System.out.println(fileName + ".rmvb decoding...");
    }
}
