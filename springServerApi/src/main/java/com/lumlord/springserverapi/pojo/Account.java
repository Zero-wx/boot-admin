package com.lumlord.springserverapi.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("t_sys_account")
public class Account implements Serializable {
    @TableId(value ="id",type = IdType.AUTO)
    private Integer id;
    private String username;
    private String password;
    private String userInfoId;
    private String salt;
    private String status;
}
