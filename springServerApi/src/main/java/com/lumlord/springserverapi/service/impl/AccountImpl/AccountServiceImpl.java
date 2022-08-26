package com.lumlord.springserverapi.service.impl.AccountImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lumlord.springserverapi.mapper.AccountMapper;
import com.lumlord.springserverapi.pojo.Account;
import com.lumlord.springserverapi.security.JwtUtil;
import com.lumlord.springserverapi.service.Account.AccountService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl extends ServiceImpl<AccountMapper, Account> implements AccountService {


    @Value("${jwt.token.expire.time}")
    private Long tokenExpireTime;

    /**
     * 根据用户登录信息生成token
     *
     * @return token
     */
    @Override
    public String loginForToken(Account account) {
        // 获取用户token值
        return JwtUtil.sign(account, tokenExpireTime);
    }


}
