package com.iris.dao;

import com.iris.po.Student;
import com.iris.po.Teacher;
import com.iris.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;

public class MyTest {
    static Logger log = Logger.getLogger(MyTest.class);
    @Test
    public void Test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = teacherMapper.getTeacher(1);
        System.out.println(teacher);
        List<Student> student = studentMapper.getStudent();
        student.forEach(System.out::println);
        List<Student> student2 = studentMapper.getStudent2();
        student2.forEach(System.out::println);
        sqlSession.close();
    }
}
