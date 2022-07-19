package com.zero.serverApi.mapper.system;

import com.zero.serverApi.bean.entity.system.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    /**
     * 查询用户
     *
     * @param userName
     * @return
     */
    User selectUser(String userName);

    /**
     * 添加记录
     *
     * @param record
     * @return
     */
    int insertUser(User record);
}
