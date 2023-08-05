package com.iris.dao;

import com.iris.po.Users;
import com.iris.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class UserMapperTest {
    static Logger log = LogManager.getFormatterLogger(UserMapperTest.class);

    @Test
    public void test() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Users user = mapper.getByName("李嘉恒");
        System.out.println(user);

        sqlSession.close();
    }

}
