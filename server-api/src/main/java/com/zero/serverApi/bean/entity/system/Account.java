package com.zero.serverApi.bean.entity.system;

import lombok.Data;

@Data
public class Account {
    private int id;
    private String userName;
    private String passWord;
    private UserInfo userId;
    private String Salt;
}
