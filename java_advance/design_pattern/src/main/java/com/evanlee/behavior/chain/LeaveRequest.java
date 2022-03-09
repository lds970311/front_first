// Author : evan lee
// Time ： 2022-03-09  20:30
// FILENAME : LeaveRequest.java
// STATEMENT: 

package com.evanlee.behavior.chain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//请假条
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LeaveRequest {
    private String name;//姓名
    private int num;//请假天数
    private String content;//请假内容
}
