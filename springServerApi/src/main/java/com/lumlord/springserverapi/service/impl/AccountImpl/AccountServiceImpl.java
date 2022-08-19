package com.lumlord.springserverapi.service.impl.AccountImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lumlord.springserverapi.mapper.AccountMapper;
import com.lumlord.springserverapi.pojo.Account;
import com.lumlord.springserverapi.service.Account.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {
}
