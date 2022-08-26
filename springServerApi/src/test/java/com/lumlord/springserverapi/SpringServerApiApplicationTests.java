package com.lumlord.springserverapi;

import com.lumlord.springserverapi.mapper.AccountMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringServerApiApplicationTests {

    @Autowired
    private AccountMapper accountMapper;

}
