package com.iris.dao;

import com.iris.po.Users;
import org.apache.ibatis.annotations.Select;

public interface UserMapperAnnotation {
    @Select("SELECT * FROM blog WHERE id like '%'#{id}'%'")
    Users getUserByName(String name);
}
