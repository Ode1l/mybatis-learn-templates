package com.iris.dao;

import com.iris.po.Users;
import com.iris.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {
    @Test
    public void testGetAll(){
        // first 获取session
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        // second 方式一: getMapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<Users> userList = userMapper.getUserList();
        for (Users users : userList) {
            System.out.println(users);
        }
        // 关闭资源
        sqlSession.close();
    }
}
