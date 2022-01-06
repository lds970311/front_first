// Author : evan lee
// Time ： 2022-01-06  1:20
// FILENAME : FirstLog.java
// STATEMENT: 

package com.codewolf.logger.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FirstLog {
    public static Logger logger = LoggerFactory.getLogger(FirstLog.class);

    public static void main(String[] args) {
        //创建log对象
        logger.debug("start debgging");

        try {
            logger.info("开始执行try");
            int a = 10;
            logger.trace("a=" + a);
            double b = 13.2;
            logger.trace("b=" + b);
            System.out.println(a / b);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
}
