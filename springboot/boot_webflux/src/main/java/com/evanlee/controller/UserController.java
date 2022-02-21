// Author : evan lee
// Time ： 2022-02-21  0:29
// FILENAME : UserController.java
// STATEMENT: 

package com.evanlee.controller;

import com.evanlee.entity.User;
import com.evanlee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("{id}")
    public Mono<User> getById(@PathVariable("id") Integer id) {
        return userService.getUserById(id);
    }

    @GetMapping
    public Flux<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public Mono<Void> addUser(@RequestBody User user) {
        return userService.saveUserInfo(Mono.just(user));
    }

}
