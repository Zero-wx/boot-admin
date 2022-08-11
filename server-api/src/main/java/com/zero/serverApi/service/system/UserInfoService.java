package com.zero.serverApi.service.system;

import com.zero.serverApi.bean.entity.system.UserInfo;
import com.zero.serverApi.mapper.system.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;


    public int insertUserInfo(Integer account_id) {
        return userInfoMapper.insertUserInfo(account_id);
    }
}
