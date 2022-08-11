package com.zero.serverApi.controller;

import com.zero.serverApi.bean.entity.system.Account;
import com.zero.serverApi.bean.exception.ApplicationException;
import com.zero.serverApi.bean.exception.BizExceptionEnum;
import com.zero.serverApi.bean.vo.result.Result;
import com.zero.serverApi.service.system.AccountService;
import com.zero.serverApi.service.system.UserInfoService;
import com.zero.serverApi.utils.MD5;
import com.zero.serverApi.utils.RandomUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录
 * 注册
 * 鉴权
 */
@RestController
@RequestMapping("/account")
public class AccountController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private AccountService accountService;

    @Autowired
    private UserInfoService userInfoService;

    /**
     * 注册账号
     *
     * @param params
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Object register(@RequestBody Account params) {
        Account account = accountService.findByAccount(params.getUserName());
        if (account == null) {
            params.setSalt(RandomUtil.getRandomString(5));
            params.setPassWord(MD5.md5(params.getPassWord(), params.getSalt()));
            accountService.insertAccount(params);
            int id = accountService.findByAccount(params.getUserName()).getId();
            userInfoService.insertUserInfo(id);
        } else {
            throw new ApplicationException(BizExceptionEnum.USER_ALREADY_REG);
        }
        return Result.success("用户创建成功:" + params.getUserName());
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Object login(@RequestBody Account params) {

        Account account = accountService.findByAccount(params.getUserName());
        if (account == null) {
            return Result.failure("用户名或密码不正确");
        }
        String passWdMD5 = MD5.md5(params.getPassWord(), account.getSalt());
        if (!account.getPassWord().equals(passWdMD5)) {
            return Result.failure("用户名或密码不正确");
        }

        String token = accountService.loginForToken(account);

    }
}




