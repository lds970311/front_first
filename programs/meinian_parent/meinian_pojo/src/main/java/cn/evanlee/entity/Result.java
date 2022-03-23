// Author : evan lee
// Time ： 2022-03-23  7:22
// FILENAME : Result.java
// STATEMENT: 

package cn.evanlee.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> implements Serializable {
    private boolean flag;//执行结果，true为执行成功 false为执行失败
    private String message;//返回结果信息
    private T data;//返回数据
}
