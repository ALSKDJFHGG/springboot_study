package io.github.alskdjfhgg.springboot.mapper;

import io.github.alskdjfhgg.springboot.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from user where username=#{username}")
    User findByUserName(String username);

    @Insert("insert into user(username, password, create_time, update_time) " +
            "values (#{username}, #{password}, now(), now())")
    void add(String username, String password);

    @Select("select password from user where username=#{username}")
    String findPasswordByUserName(String username);
}
