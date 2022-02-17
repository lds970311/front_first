// Author : evan lee
// Time ： 2022-02-16  23:42
// FILENAME : Result.java
// STATEMENT: 

package com.evan.boot_ssmp.controller.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private HttpStatus code;
    private Object data;
}
