package com.zero.serverApi.mapper.system;

import com.zero.serverApi.bean.entity.system.Account;

import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface AccountMapper {

    Account findByAccount(String userName);


    int insertAccount(Account record);


    int insertUserInfo(Account account);


    int deleteAccount(Integer id);

}
