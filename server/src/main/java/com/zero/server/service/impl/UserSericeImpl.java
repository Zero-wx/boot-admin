package com.zero.server.service.impl;

import com.zero.server.mapper.UserMapper;
import com.zero.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSericeImpl implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public List getUserInfo() {

        return userMapper.selectUser();
    }
}
