// Author : evan lee
// Time ： 2022-03-03  13:52
// FILENAME : MP4File.java
// STATEMENT: 

package com.evanlee.structure.bridging;

public class MP4File implements VideoFile {

    @Override
    public void decode(String fileName) {
        System.out.println(fileName + ".mp4 is decoding...");
    }
}
