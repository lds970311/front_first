// Author : evan lee
// Time ： 2022-02-18  22:39
// FILENAME : Info.java
// STATEMENT: 

package com.evan.boot_ssmp.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

@Data
@ConfigurationProperties(prefix = "infos")
@Validated //开启校验
public class Info {
    private String ipAddress;
    @Max(value = 20000, message = "最大不超过20000")
    @Min(value = 60, message = "最小不超过60")
    private Integer port;
    @DurationUnit(ChronoUnit.SECONDS)
    private Duration timeout;
    @DataSizeUnit(DataUnit.MEGABYTES)
    private DataSize dataSize;

    public Info() {
    }

    public Info(String ipAddress, Integer port, Duration timeout, DataSize dataSize) {
        this.ipAddress = ipAddress;
        this.port = port;
        this.timeout = timeout;
        this.dataSize = dataSize;
    }
}
