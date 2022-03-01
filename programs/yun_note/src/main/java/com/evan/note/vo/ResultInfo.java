// Author : evan lee
// Time ： 2022-02-28  22:19
// FILENAME : ResultInfo.java
// STATEMENT: 

package com.evan.note.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 封装返回结果
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultInfo<T> {
    private Integer code; //状态码,成功1,失败0
    private String message; //提示信息
    private T result; //返回结果
}
