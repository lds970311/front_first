// Author : evan lee
// Time ： 2022-03-08  23:11
// FILENAME : UserClient.java
// STATEMENT: 

package com.evan.feign.clients;


import com.evan.feign.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("userservice")
public interface UserClient {
    @GetMapping("/user/{id}")
    User findUserById(@PathVariable("id") Long id);
}
