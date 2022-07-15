package com.zero.serverApi.mapper.system;

import com.zero.serverApi.bean.entity.system.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    int insertUser(Object params);

    int deleteUser(int id);

    User selectUser(Object params);


    List<User> selectUser();
    int updateUser(Object params);


}
