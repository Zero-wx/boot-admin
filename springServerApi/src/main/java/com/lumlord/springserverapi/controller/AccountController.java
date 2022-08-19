package com.lumlord.springserverapi.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lumlord.springserverapi.exception.ApplicationException;
import com.lumlord.springserverapi.pojo.Account;
import com.lumlord.springserverapi.service.Account.AccountService;
import com.lumlord.springserverapi.utils.vo.Result;
import com.lumlord.springserverapi.utils.vo.Results;

import org.springframework.beans.factory.annotation.Autowired;
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
    public void login(@RequestBody Account params) {

        System.out.println(params);

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

        if (user == null) {

            boolean save = accountService.save(account);
            return Results.success(save);
        } else {

            throw new ApplicationException(5000, "asdasd");
        }


    }


}
