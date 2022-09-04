package com.iris.dao;

import com.iris.po.Blog;
import com.iris.utils.IdUtils;
import com.iris.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class dao {
    @Test
    public void testAdd() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = new Blog();
        blog.setId(IdUtils.getId());
        blog.setTitle("Mybatis");
        blog.setAuthor("狂神说");
        blog.setCreateTime(new Date());
        blog.setViews(9999);

        mapper.addBook(blog);

        blog.setId(IdUtils.getId());
        blog.setTitle("Java");
        mapper.addBook(blog);

        blog.setId(IdUtils.getId());
        blog.setTitle("Spring");
        mapper.addBook(blog);

        blog.setId(IdUtils.getId());
        blog.setTitle("微服务");
        mapper.addBook(blog);

        sqlSession.close();
    }

    @Test
    public void testSelectIf() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap<String, String> map = new HashMap<>();
        // map.put("title","Java");
        // map.put("author","狂神说");
        map.put("views","9999");
        List<Blog> blogs = mapper.selectChoose(map);
        blogs.forEach(System.out::println);
    }
}
