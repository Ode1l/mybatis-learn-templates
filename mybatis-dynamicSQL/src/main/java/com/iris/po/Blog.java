package com.iris.po;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Alias("blog")
@Data
public class Blog {
    // 博客id
    private String id;
    // 博客标题
    private String title;
    // 博客作者
    private String author;
    // 创建时间
    private Date createTime;
    // 浏览量
    private int views;
}
