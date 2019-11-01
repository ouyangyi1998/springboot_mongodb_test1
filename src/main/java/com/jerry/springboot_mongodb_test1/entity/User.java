package com.jerry.springboot_mongodb_test1.entity;

import lombok.Getter;
import lombok.Setter;



@Setter
@Getter
public class User {

    private String id;
    private String userName;
    private String password;
    private Integer age;
    private Long createDate;
    public User(){}
}
