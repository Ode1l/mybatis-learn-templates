package com.iris.dao;

import com.iris.po.Users;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<Users> getUserList();
    Users getUserByName(String name);
    // 分页查询
    List<Users> getUserByLimit(Map<String,Object> map);
    // 分页查询
    List<Users> getUserByRowBounds(Map<String,Object> map);
}
