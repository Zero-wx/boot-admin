package com.zero.serverApi.dao;


import com.zero.serverApi.entity.UserEntity;

import java.util.List;
import java.util.Map;

public interface UserDao {
    public List<Map<String, Object>> getUserInfo(String account);
}
