package com.iris.dao;

import com.iris.po.Teacher;
import org.apache.ibatis.annotations.Param;

public interface TeacherMapper {
    Teacher getTeacher(@Param("tid")int id);
}
