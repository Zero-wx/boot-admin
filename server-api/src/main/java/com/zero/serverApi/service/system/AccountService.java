package com.zero.serverApi.service.system;


import com.zero.serverApi.bean.entity.system.Account;
import com.zero.serverApi.mapper.system.AccountMapper;
import com.zero.serverApi.service.BaseService;
import com.zero.serverApi.utils.JWT.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class AccountService<T> extends BaseService<T> {
    private Logger logger = LoggerFactory.getLogger(AccountService.class);

    @Autowired
    private AccountMapper accountMapper;

    @Value("${jwt.token.expire.time}")
    private Long tokenExpireTime;

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

        String token = JwtUtil.sign(account, tokenExpireTime * 6000);

        String refreshTokenCacheKey = token;

        Date expireDate = new Date(System.currentTimeMillis() + tokenExpireTime * 120000);
        logger.info("token:{}", token);
        return token;

    }


}
