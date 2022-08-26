package com.lumlord.springserverapi.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lumlord.springserverapi.exception.ApplicationException;
import com.lumlord.springserverapi.exception.ApplicationExceptionEnum;
import com.lumlord.springserverapi.pojo.Account;
import com.lumlord.springserverapi.service.Account.AccountService;
import com.lumlord.springserverapi.utils.MD5;
import com.lumlord.springserverapi.utils.RandomUtil;
import com.lumlord.springserverapi.utils.vo.Result;
import com.lumlord.springserverapi.utils.vo.Results;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Object login(@RequestBody Account account) {
        QueryWrapper<Account> AccountWrapper = new QueryWrapper<>();
        AccountWrapper.eq("username", account.getUsername());
        Account user = accountService.getOne(AccountWrapper);




        if (user == null) {
            return Results.failure("用户名或密码错误");
        }
        String passwdMd5 = MD5.md5(account.getPassword(), user.getSalt());
        if (!user.getPassword().equals(passwdMd5)) {
            return Results.failure("用户名或密码错误");
        }

        String token = accountService.loginForToken(user);


        System.out.println(user);
        return Results.success(token);
    }

    /**
     * 注册账户
     *
     * @param account username password
     * @return 成功
     */

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Result<?> register(@RequestBody Account account) {
        QueryWrapper<Account> AccountWrapper = new QueryWrapper<>();
        AccountWrapper.eq("username", account.getUsername());
        Account user = accountService.getOne(AccountWrapper);
        if (user != null) {
            throw new ApplicationException(ApplicationExceptionEnum.USER_ALREADY_REG);
        } else {
            account.setSalt(RandomUtil.getRandomString(5));
            account.setPassword(MD5.md5(account.getPassword(), account.getSalt()));
            accountService.save(account);
            return Results.success();
        }
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public Object TestAccount() {
        return Results.success("测试token");
    }


}
