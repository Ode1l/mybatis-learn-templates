package com.iris.dao;

import com.iris.po.Users;
import com.iris.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {
    static Logger log = LogManager.getFormatterLogger(UserMapperTest.class);

    @Test
    public void testGetAll() {
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

    @Test
    public void testGetByName() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Users user = mapper.getUserByName("雪");
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void testLog4j() {
        log.info("进入info");
        log.debug("进入debug");
        log.error("进入error");
        log.warn("进入warn");
    }

    @Test
    public void testGetByLimit() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("StartIndex", 0);
        map.put("PageSize", 2);
        List<Users> userList = mapper.getUserByLimit(map);
        for (Users users : userList) {
            System.out.println(users);
        }
        sqlSession.close();
    }

    @Test
    public void testGetByByRowBounds() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        RowBounds rowBounds = new RowBounds(0, 1);
        List<Users> userList = sqlSession.selectList("com.iris.dao.UserMapper.getUserByRowBounds", null, rowBounds);
        for (Users users : userList) {
            System.out.println(users);
        }
        sqlSession.close();
    }
}
