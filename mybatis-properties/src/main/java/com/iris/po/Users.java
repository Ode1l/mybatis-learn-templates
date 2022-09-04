package com.iris.po;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Alias("UserAlias")
@Data
public class Users {
    private int id;
    private String name;
    private  int age;
    private String city;
    private String liveCity;

    public Users(int id, String name, int age, String city) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.city = city;
    }
}
