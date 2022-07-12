package com.zero.serverApi.entity;

import lombok.Data;

@Data
public class UserEntity {
    private Long id;

    private String account;

    private String password;

    private String name;

    private Integer age;

    private String phone;

    private String roleId;

}



