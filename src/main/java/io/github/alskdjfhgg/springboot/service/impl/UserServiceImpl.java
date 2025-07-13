package io.github.alskdjfhgg.springboot.service.impl;

import io.github.alskdjfhgg.springboot.mapper.UserMapper;
import io.github.alskdjfhgg.springboot.pojo.Result;
import io.github.alskdjfhgg.springboot.pojo.User;
import io.github.alskdjfhgg.springboot.service.UserService;
import io.github.alskdjfhgg.springboot.utils.JwtUtil;
import io.github.alskdjfhgg.springboot.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public Result register(String username, String password) {
        // 1, 查询用户
        User user = userMapper.findByUserName(username);
        if (user == null) {
        // 2, 新用户注册
            String md5String = Md5Util.getMD5String(password);
            userMapper.add(username, md5String);
            return Result.success();
        }
        else {
            return Result.error("用户名已存在！");
        }
    }

    @Override
    public Result<String> login(String username, String password) {
        /*
       1, 查询用户是否存在
       2, 密码匹配
       3, 密码错误
         */
        if (userMapper.findByUserName(username) == null) {
            return Result.error("用户名或密码错误！");
        }
        if (!Md5Util.checkPassword(password, userMapper.findPasswordByUserName(username))) {
            return Result.error("用户名或密码错误！");
        }
        Map<String, Object> user = new HashMap<>();
        user.put("id", userMapper.findByUserName(username).getId());
        user.put("username", username);
        return Result.success(JwtUtil.JwtGen(user));
    }
}
