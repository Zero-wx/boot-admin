package com.zero.serverApi.bean.entity.system;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String userName;
    private String passWord;
    private String name;
    private Integer pid;
    private String Salt;
}
