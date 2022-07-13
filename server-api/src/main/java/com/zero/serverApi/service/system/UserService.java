package com.zero.serverApi.service.system;


import com.zero.serverApi.entity.system.User;
import com.zero.serverApi.mapper.system.UserMapper;
import com.zero.serverApi.service.CURDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService<T> implements CURDService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 增加记录
     *
     * @param record
     * @return
     */
    @Override
    public int insert(Object record) {
        return userMapper.insertUser(record);
    }

    @Override
    public int delete(Integer id) {
        return userMapper.deleteUser(id);
    }

    @Override
    public List select() {
        return userMapper.selectUser();
    }

    @Override
    public int update(Object params) {
        return userMapper.updateUser(params);
    }


}
