// Author : evan lee
// Time ： 2022-03-15  21:52
// FILENAME : UserController.java
// STATEMENT: 

package cn.evanlee.controller;


import cn.evan.service.UserService;
import cn.evanlee.pojo.User;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.rpc.cluster.loadbalance.RandomLoadBalance;
import org.apache.dubbo.rpc.cluster.support.FailoverCluster;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Reference(timeout = 1000, version = "v1.0", loadbalance = RandomLoadBalance.NAME,
            cluster = FailoverCluster.NAME, mock = "fail:return null")
    private UserService userService;

    @GetMapping("/sayHello")
    public String sayHell() {
        return userService.sayHello();
    }

    @GetMapping("find")
    public User getUser() {
        return userService.getUserById(1);
    }
}
