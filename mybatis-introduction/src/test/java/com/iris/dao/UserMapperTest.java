package com.iris.dao;

import com.iris.po.Users;
import com.iris.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
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
    @Test
    public void testGetByName() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Users user = mapper.getUserByName("雪");
        System.out.println(user);
        sqlSession.close();
    }
    // 增删改需要提交事务!!!
    @Test
    public void testAdd() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int result = mapper.addUser(new Users(3,"李吉晟",22,"天津"));
        if (result > 0) {
            System.out.println("insert success");
        }
        // 提交事务
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testAddMap() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        HashMap<String, Object> map = new HashMap<>();
        map.put("userName","李吉晟");
        map.put("userAge","23");
        map.put("userCity","天津");
        int result = mapper.addUserObj(map);
        if (result > 0) {
            System.out.println("insert success");
        }
        // 提交事务
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testUpdate() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int res = mapper.updateUser(new Users(3, "李吉晟", 21, "平顶山"));
        if (res > 0) {
            System.out.println("update success");
        }
        // 提交事务
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testDelete() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int res = mapper.deleteUser(new Users(0, "李吉晟", 0, null));
        if (res > 0) {
            System.out.println("delete success");
        }
        // 提交事务
        sqlSession.commit();
        sqlSession.close();
    }
}
