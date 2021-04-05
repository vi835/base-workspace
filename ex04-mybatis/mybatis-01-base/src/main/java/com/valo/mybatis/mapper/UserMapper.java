package com.valo.mybatis.mapper;

import com.valo.mybatis.domain.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> getUser();

    User getUserById(int id);

    Integer insertUser(User user);

    Integer insertUser2(Map<Object,Object> map);

    // 分页
    List<User> getUserByLimit(Map<String,Integer> map);

    List<User> getUserByRowBounds();
}
