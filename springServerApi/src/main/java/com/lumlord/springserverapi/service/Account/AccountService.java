package com.lumlord.springserverapi.service.Account;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lumlord.springserverapi.pojo.Account;

public interface AccountService extends IService<Account> {
    String loginForToken(Account account);
}
