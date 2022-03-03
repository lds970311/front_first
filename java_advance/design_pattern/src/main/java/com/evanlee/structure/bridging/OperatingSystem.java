// Author : evan lee
// Time ： 2022-03-03  13:53
// FILENAME : OperatingSystem.java
// STATEMENT: 

package com.evanlee.structure.bridging;

import lombok.Getter;

//操作系统版本
public abstract class OperatingSystem {
    @Getter
    private final VideoFile videoFile;

    public OperatingSystem(VideoFile videoFile) {
        this.videoFile = videoFile;
    }

    protected abstract void playVideo(String filename);
}
