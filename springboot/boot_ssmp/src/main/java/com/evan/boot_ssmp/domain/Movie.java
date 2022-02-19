// Author : evan lee
// Time ： 2022-02-19  19:35
// FILENAME : Movie.java
// STATEMENT: 

package com.evan.boot_ssmp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@ConfigurationProperties(prefix = "testcase.movie")
public class Movie {
    private Integer id;
    private String title;
    private String actor;
}
