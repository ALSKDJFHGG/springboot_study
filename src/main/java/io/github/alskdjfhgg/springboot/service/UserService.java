package io.github.alskdjfhgg.springboot.service;

import io.github.alskdjfhgg.springboot.pojo.Result;

public interface UserService {
    Result register(String username, String password);

    Result login(String username, String password);
}
