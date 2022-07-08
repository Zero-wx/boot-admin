package com.zero.server.controller;


import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/account")
public class AccountController {

    // 注册
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void login() {
        System.out.println("请求进入");
    }
    // 登录


}

