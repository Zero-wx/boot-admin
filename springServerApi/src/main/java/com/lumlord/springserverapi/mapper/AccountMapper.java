package com.lumlord.springserverapi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lumlord.springserverapi.pojo.Account;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;


@Mapper
@Transactional
public interface AccountMapper extends BaseMapper<Account> {
}
