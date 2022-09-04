package com.iris.po;

import lombok.Data;

@Data
public class Student {
    private int id;
    private String name;
    private Integer tid;
    private Teacher teacher;
}
