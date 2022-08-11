package com.zero.serverApi.mapper.system;

import com.zero.serverApi.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoMapper extends BaseMapper {

    int insertUserInfo(Integer id);
}
