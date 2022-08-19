package com.lumlord.springserverapi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lumlord.springserverapi.pojo.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountMapper extends BaseMapper<Account> {


}
