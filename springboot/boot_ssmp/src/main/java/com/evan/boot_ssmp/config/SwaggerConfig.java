// Author : evan lee
// Time ： 2022-02-19  23:00
// FILENAME : SwaggerConfig.java
// STATEMENT: 

package com.evan.boot_ssmp.config;

import com.evan.boot_ssmp.annotations.NotIncludeSwagger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import static com.google.common.base.Predicates.not;
import static springfox.documentation.builders.RequestHandlerSelectors.withMethodAnnotation;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket getDocket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(this.swaggerInfo())
                .select()
                //可以通过apis()方法设置哪个包中内容被扫描
                .apis(not(withMethodAnnotation(NotIncludeSwagger.class)))
                .build();
    }

    private ApiInfo swaggerInfo() {
        return new ApiInfoBuilder()
                .contact(new Contact("evan lee", "https://github.com/lds970311", "ldk2696622575@gmail.com"))
                .title("boot_ssmp 整合")
                .description("boot_ssmp 整合")
                .version("1.0")
                .build();
    }
}
