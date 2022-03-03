// Author : evan lee
// Time ： 2022-03-03  13:58
// FILENAME : Mac.java
// STATEMENT: 

package com.evanlee.structure.bridging;

public class Mac extends OperatingSystem {

    public Mac(VideoFile videoFile) {
        super(videoFile);
    }

    @Override
    public void playVideo(String filename) {
        super.getVideoFile().decode(filename);
    }
}
