// Author : evan lee
// Time ： 2022-02-12  11:20
// FILENAME : MbgTest.java
// STATEMENT: 

package com.evan;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MbgTest {

    @SneakyThrows
    @Test
    public void generatorTest() {
        URL resource = MbgTest.class.getClassLoader().getResource("mbg.xml");
        String path = resource.getPath();
        System.out.println(path);
        List<String> warnings = new ArrayList<>();
        File configFile = new File(path);
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(true);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config,
                callback, warnings);
        myBatisGenerator.generate(null);
    }
}
