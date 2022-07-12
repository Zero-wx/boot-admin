package com.zero.serverApi.service.impl;


import com.zero.serverApi.dao.UserDao;
import com.zero.serverApi.entity.UserEntity;
import com.zero.serverApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public String getUserInfo(String account) {

        List<Map<String, Object>> userInfo = userDao.getUserInfo(account);

        System.out.println(userInfo);


        return account;


    }
}
