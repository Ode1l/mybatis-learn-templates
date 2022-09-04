package com.iris.dao;

import com.iris.po.Users;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


public interface UserMapper {
    @Select("select * from mybatis.users where name like #{name}")
    Users getByName (@Param("name") String name);
}
