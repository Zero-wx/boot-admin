package com.zero.serverApi.contorller;

import com.zero.serverApi.entity.UserEntity;

import com.zero.serverApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * 请求权限相关
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private UserService userService;

    /**
     * 注册用户
     *
     * @return
     */
    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    public void register(@RequestBody UserEntity params) {


        String userInfo = userService.getUserInfo(params.getAccount());
        System.out.println(userInfo);

    }
}
