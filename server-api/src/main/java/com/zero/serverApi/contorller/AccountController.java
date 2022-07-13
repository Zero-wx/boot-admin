package com.zero.serverApi.contorller;


import com.zero.serverApi.service.system.UserService;
import com.zero.serverApi.utils.result.Results;
import com.zero.serverApi.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 请求权限相关
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private UserService userService;

    /**
     * 用户注册功能
     *
     * @return 注册成功信息
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Object register(@RequestBody Map<Object, Object> params) {
        int i = userService.insert(params);
        return Result.success(i);
    }

    /**
     * 删除用户
     *
     * @param params
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Results deleteUser(@RequestBody Map<Object, Integer> params) {
        int delete = userService.delete(params.get("id"));
        return Result.success(delete);
    }

    /**
     * 修改信息
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Results upDataUser(@RequestBody Map<Object, Object> params) {
        int update = userService.update(params);
        return Result.success(update);
    }


    /**
     * 查询用户信息
     *
     * @return
     */
    @RequestMapping(value = "/userList", method = RequestMethod.GET)
    public Results getUserList() {
        Object userList = userService.select();

        return Result.success(userList);
    }


}
