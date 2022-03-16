// Author : evan lee
// Time ： 2022-03-15  22:32
// FILENAME : UserService.java
// STATEMENT: 

package cn.evan.service;

import cn.evanlee.pojo.User;

public interface UserService {
    String sayHello();

    User getUserById(Integer id);
}
