// Author : evan lee
// Time ： 2022-01-09  18:53
// FILENAME : Wolf.java
// STATEMENT: 

package com.codewolf.java.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface Wolf {
    String name();

    String location() default "China";
}
