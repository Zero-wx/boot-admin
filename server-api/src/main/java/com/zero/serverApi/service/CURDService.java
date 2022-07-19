package com.zero.serverApi.service;

import com.zero.serverApi.bean.entity.system.User;

/**
 * 增删改查service
 */
public interface CURDService {

    User findByAccount(String userName);

    int insert(User record);

}
