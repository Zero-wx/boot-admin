package com.zero.serverApi.mapper.system;

import com.zero.serverApi.bean.entity.system.Account;

import com.zero.serverApi.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface AccountMapper extends BaseMapper {

    Account findByAccount(String account);

    void insertAccount(Account account);

    int selectByAccount(String account);
}
