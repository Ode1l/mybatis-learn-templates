package com.iris.dao;

import com.iris.po.Users;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<Users> getUserList();
    Users getUserByName(String name);
    int addUser(Users user);
    int addUserObj(Map<String, Object> map);
    int updateUser(Users user);
    int deleteUser(Users users);
}
