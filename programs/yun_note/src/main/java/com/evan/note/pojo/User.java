// Author : evan lee
// Time ： 2022-02-28  22:10
// FILENAME : User.java
// STATEMENT: 

package com.evan.note.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer userId;
    private String uname;
    private String upwd; //密码
    private String nick; //昵称
    private String head; //头像
    private String mood; //签名
}
