package com.zero.serverApi.mapper.system;

import com.zero.serverApi.bean.entity.system.Account;
import com.zero.serverApi.bean.entity.system.UserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    /**
     * 查询用户
     *
     * @param userName
     * @return
     */
    Account selectUser(String userName);

    /**
     * 添加记录
     *
     * @param record
     * @return
     */
    int insertUser(UserInfo record);
}
