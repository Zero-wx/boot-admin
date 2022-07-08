package com.zero.server.controller.system;

import com.zero.server.entity.userModel.User;
import com.zero.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 用户相关Controller
 */
@RestController
@RequestMapping("/user")
public class userController {

    @Autowired
    private UserService userService;

    // 新增用户
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public List registerUser(@RequestBody Map<Object, String> params) {


        List userInfo = userService.getUserInfo();


        System.out.println(userInfo);
        System.out.println(params.get("passWord"));

        return userInfo;

    }
}
