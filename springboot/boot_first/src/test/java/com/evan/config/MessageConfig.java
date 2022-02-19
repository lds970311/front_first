// Author : evan lee
// Time ： 2022-02-19  14:21
// FILENAME : MessageConfig.java
// STATEMENT: 

package com.evan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConfig {
    @Bean
    public String msg() {
        return "String bean";
    }
}
