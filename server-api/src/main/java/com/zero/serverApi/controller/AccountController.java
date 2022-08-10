package com.zero.serverApi.controller;

import com.zero.serverApi.bean.entity.system.Account;
import com.zero.serverApi.bean.exception.ApplicationException;
import com.zero.serverApi.bean.exception.BizExceptionEnum;
import com.zero.serverApi.bean.vo.result.Result;
import com.zero.serverApi.bean.vo.result.Results;
import com.zero.serverApi.service.system.AccountService;
import com.zero.serverApi.service.system.UserService;
import com.zero.serverApi.utils.MD5;
import com.zero.serverApi.utils.RandomUtil;
import com.zero.serverApi.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class AccountController extends BaseController {

    private Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private AccountService accountService;

    /**
     * 用户注册功能
     *
     * @return 注册成功信息
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Results register(@RequestBody Account params) {
        // 查询用户是否存在
        Account account = accountService.findByAccount(params.getUserName());
        if (account != null) {
            throw new ApplicationException(BizExceptionEnum.USER_ALREADY_REG);
        } else {
            params.setSalt(RandomUtil.getRandomString(5));
            params.setPassWord(MD5.md5(params.getPassWord(), params.getSalt()));
            int insert = accountService.insert(params);
            Integer id = params.getId();


            int i = accountService.insertUserInfo(params);
            return Result.success(i);
        }
    }

    /**
     * 登录
     *
     * @return 返回Token
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Results login(@RequestBody Account params) {


        System.out.println(params.getUserName());
        try {
            Account account = accountService.findByAccount(params.getUserName());
            if (account == null) {
                return Result.failure("用户名或密码错误");
            }

            String passWordWmd5 = MD5.md5(params.getPassWord(), account.getSalt());


            if (!account.getPassWord().equals(passWordWmd5)) {
                return Result.failure("用户名或密码错误！！！");
            }

//            System.out.println(account.getRole_id());


//            if (StringUtil.isEmpty(account.getRole_id())) {
//                return Result.failure("该用户未配置权限");
//            }


//            System.out.println(equals);
//
//            return Result.success(equals);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

        return Result.success(null);
    }


    @RequestMapping(value = "/deleteAccount", method = RequestMethod.DELETE)
    public Results deleteAccount(@RequestBody Map<Object, Integer> params) {

        System.out.println(params.get("id"));
        int i = accountService.deleteAccount(params.get("id"));
        return Result.success(null);
    }


//    /**
//     * 登录
//     *
//     * @return TOKEN
//     */
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public Results login(@RequestBody Map<Object, String> params) {
//        try {
//            User user = userService.findByAccount(params.get("userName"));
//            if (user == null) {
//                return Result.failure("用户名或密码错误");
//            }
//            String passWordMD5 = MD5.md5(params.get("passWord"), user.getSalt());
//            if (!user.getPassWord().equals(passWordMD5)){
//                return Result.failure("用户名或者密码错误");
//            }
//
//
//
//
//        } catch (Exception e) {
//            logger.error(e.getMessage(), e);
//        }
//        return Result.success(null);
//    }
//
//    /**
//     * 用户详细信息
//     *
//     * @return
//     */
//    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
//    public Results userInfo() {
//        HttpServletRequest request = HttpUtil.getRequest();
//
//        Long idUser = null;
//        try {
//            idUser = getIdUser(request);
//        } catch (Exception e) {
//            return Result.expire();
//        }
//
//        return Result.success("成功");
//    }

}




