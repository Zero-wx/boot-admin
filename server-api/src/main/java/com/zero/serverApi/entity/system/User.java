package com.zero.serverApi.entity.system;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String userName;
    private String passWord;
    private Integer pid;
}
