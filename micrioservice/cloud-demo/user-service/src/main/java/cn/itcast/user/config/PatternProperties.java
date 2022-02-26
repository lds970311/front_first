// Author : evan lee
// Time ： 2022-02-25  23:19
// FILENAME : PatternProperties.java
// STATEMENT: 

package cn.itcast.user.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "pattern")
public class PatternProperties {
    private String dateformat;
}
