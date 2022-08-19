package com.lumlord.springserverapi.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_sys_account")
public class Account {
    @TableId(value = "id",type = IdType.INPUT)
    private Integer id;
    private String username;
    private String password;
    private String userInfoId;
    private String salt;
    private String status;
}
