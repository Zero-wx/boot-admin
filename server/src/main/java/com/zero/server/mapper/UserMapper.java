package com.zero.server.mapper;

import com.zero.server.entity.userModel.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List selectUser();
}
