// Author : evan lee
// Time ： 2022-03-03  13:51
// FILENAME : AVIFile.java
// STATEMENT: 

package com.evanlee.structure.bridging;

public class AVIFile implements VideoFile {

    @Override
    public void decode(String fileName) {
        System.out.println(fileName + ".avi decoding...");
    }
}
