package com.iris.dao;

import com.iris.po.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    // 准备环节 插入数据
    void addBook(Blog blog);
    // 查询 if
    List<Blog> selectIf(Map<String, String> map);

    //
    List<Blog> selectChoose(Map<String, String> map);
}
