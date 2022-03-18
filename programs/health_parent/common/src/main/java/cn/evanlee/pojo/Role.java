// Author : evan lee
// Time ： 2022-03-17  19:48
// FILENAME : Role.java
// STATEMENT: 

package cn.evanlee.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.User;

import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role implements Serializable {
    private Integer id;
    private String name; // 角色名称
    private String keyword; // 角色关键字，用于权限控制
    private String description; // 描述
    private Set<User> users = new HashSet<>(0);
    private Set<Permission> permissions = new HashSet<>(0);
    private LinkedHashSet<Menu> menus = new LinkedHashSet<>(0);
}
