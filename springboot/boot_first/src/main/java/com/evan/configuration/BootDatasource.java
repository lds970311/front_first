// Author : evan lee
// Time ： 2022-02-13  21:22
// FILENAME : BootDatasource.java
// STATEMENT: 

package com.evan.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "datasource")
public class BootDatasource {
    private String driver;
    private String url;
    private String username;
    private String password;

    public BootDatasource() {

    }

    public BootDatasource(String driver, String url, String username, String password) {
        this.driver = driver;
        this.url = url;
        this.username = username;
        this.password = password;
    }
}
