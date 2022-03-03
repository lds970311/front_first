// Author : evan lee
// Time ： 2022-03-03  14:04
// FILENAME : Linux.java
// STATEMENT: 

package com.evanlee.structure.bridging;

public class Linux extends OperatingSystem {

    public Linux(VideoFile videoFile) {
        super(videoFile);
    }

    @Override
    public void playVideo(String filename) {
        super.getVideoFile().decode(filename);
    }
}
