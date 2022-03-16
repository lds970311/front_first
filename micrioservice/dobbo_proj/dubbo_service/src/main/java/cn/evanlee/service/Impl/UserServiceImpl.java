// Author : evan lee
// Time ： 2022-03-15  21:41
// FILENAME : UserServiceImpl.java
// STATEMENT: 

package cn.evanlee.service.Impl;


import cn.evan.service.UserService;
import cn.evanlee.pojo.User;
import org.apache.dubbo.config.annotation.Service;

@Service(timeout = 2000, retries = 0, version = "v1.0",
        weight = 200) //当前服务3s超时
public class UserServiceImpl implements UserService {

    public String sayHello() {
        return "Hello Dubbo";
    }

    @Override
    public User getUserById(Integer id) {
        return new User(1, "anni", "888111");
    }
}
