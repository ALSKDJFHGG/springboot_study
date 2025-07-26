package io.github.alskdjfhgg.springboot.service;

import io.github.alskdjfhgg.springboot.pojo.Result;
import io.github.alskdjfhgg.springboot.pojo.User;

public interface UserService {
    Result register(String username, String password);

    Result<String> login(String username, String password);

    Result<User> userInfo(String token);
}
