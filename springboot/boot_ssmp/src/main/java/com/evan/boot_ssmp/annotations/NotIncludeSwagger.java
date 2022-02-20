// Author : evan lee
// Time ： 2022-02-19  23:41
// FILENAME : NotIncludeSwagger.java
// STATEMENT: 

package com.evan.boot_ssmp.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotIncludeSwagger {
}
