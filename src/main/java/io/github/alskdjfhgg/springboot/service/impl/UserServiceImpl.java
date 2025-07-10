package io.github.alskdjfhgg.springboot.service.impl;

import io.github.alskdjfhgg.springboot.mapper.UserMapper;
import io.github.alskdjfhgg.springboot.pojo.User;
import io.github.alskdjfhgg.springboot.service.UserService;
import io.github.alskdjfhgg.springboot.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public boolean register(String username, String password) {
        // 1, 查询用户
        User user = userMapper.findByUserName(username);
        if (user == null) {
        // 2, 新用户注册
            String md5String = Md5Util.getMD5String(password);
            userMapper.add(username, md5String);
            return true;
        }
        else {
            return false;
        }

    }
}
