package com.zero.serverApi.bean.entity.system;

import lombok.Data;

import java.util.Date;

@Data
public class UserInfo {
    private int id;
    private String avatar;
    private String name;
    private Date birthday;
    private int sex;
    private String email;
    private String phone;
    private int roleId;
    private String deptId;
    private int status;
    private int account_id;
}
