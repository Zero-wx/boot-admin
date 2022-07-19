package com.zero.serverApi.contorller;

import com.zero.serverApi.bean.entity.system.User;
import com.zero.serverApi.bean.exception.ApplicationException;
import com.zero.serverApi.bean.exception.BizExceptionEnum;
import com.zero.serverApi.bean.vo.result.Result;
import com.zero.serverApi.bean.vo.result.Results;
import com.zero.serverApi.service.system.UserService;
import com.zero.serverApi.utils.MD5;
import com.zero.serverApi.utils.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
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
    public Results register(@RequestBody User params) {
        // 查询用户是否存在
        User Account = userService.findByAccount(params.getUserName());
        if (Account != null) {
            throw new ApplicationException(BizExceptionEnum.USER_ALREADY_REG);
        } else {
            params.setSalt(RandomUtil.getRandomString(5));
            params.setPassWord(MD5.md5(params.getPassWord(), params.getSalt()));
            int insert = userService.insert(params);
            return Result.success(insert);
        }
    }

    /**
     * 登录
     *
     * @return TOKEN
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Results login(@RequestBody Map<Object, String> params) {

        User Account = userService.findByAccount(params.get("userName"));

        if (Account == null) {
            return Result.failure("用户名或密码错误");
        }
        String passWordMd5 = MD5.md5(params.get("passWord"), Account.getSalt());

        if (!Account.getPassWord().equals(passWordMd5)) {
            return Result.failure("用户名或密码错误");
        }

        String token = userService.loginForToken(Account);
        HashMap<Object, Object> result = new HashMap<>();
        result.put("token", token);
        return Result.success(result);
    }

}




