// Author : evan lee
// Time ： 2022-02-14  12:33
// FILENAME : LogbackTest.java
// STATEMENT: 

package com.evan.logger;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogbackTest {
    private static final Logger logger = LoggerFactory.getLogger(LogbackTest.class);

    @Test
    public void loggerWrite() {
        logger.debug("writing...");
    }
}
