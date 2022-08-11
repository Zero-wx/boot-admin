package com.zero.serverApi.service.system;


import com.zero.serverApi.bean.entity.system.Account;
import com.zero.serverApi.mapper.system.AccountMapper;
import com.zero.serverApi.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AccountService<T> extends BaseService<T> {

    @Autowired
    private AccountMapper accountMapper;

    public Account findByAccount(String account) {
        return accountMapper.findByAccount(account);
    }

    public void insertAccount(Account account) {
        accountMapper.insertAccount(account);
    }

    public int selectByAccount(String account) {
        return accountMapper.selectByAccount(account);
    }


    public String loginForToken(Account account) {




        return "";

    }


}
