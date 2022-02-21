// Author : evan lee
// Time ： 2022-02-21  0:15
// FILENAME : UserService.java
// STATEMENT: 

package com.evanlee.service;

import com.evanlee.entity.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
    Mono<User> getUserById(Integer id);

    Flux<User> getAllUsers();

    Mono<Void> saveUserInfo(Mono<User> user);
}
