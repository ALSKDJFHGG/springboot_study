package io.github.alskdjfhgg.springboot.controller;

import io.github.alskdjfhgg.springboot.pojo.Result;
import io.github.alskdjfhgg.springboot.pojo.User;
import io.github.alskdjfhgg.springboot.service.UserService;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(@Pattern(regexp = "^\\S{5,16}$") String username,@Pattern(regexp = "^\\S{5,16}$") String password) {
        return userService.register(username, password);
    }

    @PostMapping("/login")
    public Result<String> login(@Pattern(regexp = "^\\S{5,16}$") String username,@Pattern(regexp = "^\\S{5,16}$") String password) {
        return userService.login(username, password);
    }

    @PostMapping("/userinfo")
    public Result<User> userinfo(@RequestHeader(name = "Authorization") String token) {
        return userService.userInfo(token);
    }
}
