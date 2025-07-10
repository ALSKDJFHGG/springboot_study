package io.github.alskdjfhgg.springboot.controller;

import io.github.alskdjfhgg.springboot.pojo.Result;
import io.github.alskdjfhgg.springboot.pojo.User;
import io.github.alskdjfhgg.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/register")
    public Result register(String username, String password) {
        if (userService.register(username, password)) {
            return Result.success();
        }
        return Result.error("用户已存在！");
    }
}
