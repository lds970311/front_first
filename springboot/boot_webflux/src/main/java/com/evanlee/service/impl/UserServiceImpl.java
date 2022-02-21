// Author : evan lee
// Time ： 2022-02-21  0:18
// FILENAME : UserServiceImpl.java
// STATEMENT: 

package com.evanlee.service.impl;

import com.evanlee.entity.User;
import com.evanlee.service.UserService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    //创建map集合存储数据
    private final Map<Integer, User> users = new HashMap<>();

    public UserServiceImpl() {
        this.users.put(1, new User("lucy", 21, "male"));
        this.users.put(2, new User("mary", 30, "female"));
        this.users.put(3, new User("jack", 43, "male"));
    }

    @Override
    public Mono<User> getUserById(Integer id) {
        User user = users.get(id);
        return Mono.just(user);
    }

    @Override
    public Flux<User> getAllUsers() {
        return Flux.fromIterable(users.values());
    }

    @Override
    public Mono<Void> saveUserInfo(Mono<User> userMono) {
        return userMono.doOnNext(user -> {
            users.put(UUID.randomUUID().variant(), user);
        }).thenEmpty(Mono.empty());
    }
}
