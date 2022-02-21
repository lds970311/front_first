// Author : evan lee
// Time ： 2022-02-21  13:46
// FILENAME : UserHandler.java
// STATEMENT: 

package com.evanlee.handler;

import com.evanlee.entity.User;
import com.evanlee.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;

public class UserHandler {
    private final UserService userService;

    public UserHandler(UserService userService) {
        this.userService = userService;
    }

    //根据id查询
    public Mono<ServerResponse> getUserById(ServerRequest request) {
        int id = Integer.parseInt(request.pathVariable("id"));
        //空值处理
        Mono<ServerResponse> notFound = ServerResponse.notFound().build();
        Mono<User> userMono = this.userService.getUserById(id);
        //把userMono进行转换
        return userMono
                .flatMap(person -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                        .body(fromObject(person)))
                .switchIfEmpty(notFound);
    }

    //查询全部
    public Mono<ServerResponse> getAll(ServerRequest request) {
        Flux<User> allUsers = this.userService.getAllUsers();
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(allUsers, User.class);
    }

    //添加
    public Mono<ServerResponse> saveUser(ServerRequest request) {
        Mono<User> userMono = request.bodyToMono(User.class);
        return ServerResponse.ok()
                .build(this.userService.saveUserInfo(userMono));

    }
}
