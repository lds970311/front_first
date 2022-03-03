// Author : evan lee
// Time ： 2022-03-03  13:56
// FILENAME : Windows.java
// STATEMENT: 

package com.evanlee.structure.bridging;

public class Windows extends OperatingSystem {

    public Windows(VideoFile videoFile) {
        super(videoFile);
    }

    @Override
    public void playVideo(String filename) {
        super.getVideoFile().decode(filename);
    }
}
