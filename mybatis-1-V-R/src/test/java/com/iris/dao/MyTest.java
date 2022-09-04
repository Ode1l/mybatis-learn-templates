package com.iris.dao;

import com.iris.po.Teacher;
import com.iris.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {
    @Test
    public void Test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        List<Teacher> teacher = mapper.getTeacher();
        List<Teacher> teacher2 = mapper.getTeacher2();
        teacher.forEach(System.out::println);
        teacher2.forEach(System.out::println);
        sqlSession.close();
    }
}
