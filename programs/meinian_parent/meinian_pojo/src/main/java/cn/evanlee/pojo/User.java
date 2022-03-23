// Author : evan lee
// Time ： 2022-03-23  7:05
// FILENAME : User.java
// STATEMENT: 

package cn.evanlee.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 用户
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private Date birthday; // 生日
    private String gender; // 性别
    private String username; // 用户名，唯一
    private String password; // 密码
    private String remark; // 备注
    private String station; // 状态
    private String telephone; // 联系电话
    private Set<Role> roles = new HashSet<>(0);//对应角色集合
}
