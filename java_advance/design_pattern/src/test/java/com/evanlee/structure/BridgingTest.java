// Author : evan lee
// Time ： 2022-03-03  13:58
// FILENAME : BridgingTest.java
// STATEMENT: 

package com.evanlee.structure;

import com.evanlee.structure.bridging.*;
import org.junit.jupiter.api.Test;

public class BridgingTest {
    @Test
    void OSTest() {
        Windows windows = new Windows(new AVIFile());
        windows.playVideo("times"); //times.avi decoding...
        Mac mac = new Mac(new MP4File());
        mac.playVideo("hours"); //hours.mp4 is decoding...
        Mac mac1 = new Mac(new RMVBFile());
        mac1.playVideo("seconds");
        Linux linux = new Linux(new MP4File());
        linux.playVideo("days");
    }
}
