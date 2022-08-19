package com.lumlord.springserverapi;

import com.lumlord.springserverapi.mapper.AccountMapper;
import com.lumlord.springserverapi.pojo.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringServerApiApplicationTests {


    @Autowired
    private AccountMapper accountMapper;

    @Test
    void contextLoads() {
    }


    @Test
    void xxx() {


        Account account = new Account();


        account.setId(1);
        account.setUsername("sad阿斯顿撒");
        account.setPassword("aaa");


        int insert = accountMapper.insert(account);


    }

}
