package com.zero.serverApi.contorller;


import com.zero.serverApi.bean.entity.system.User;
import com.zero.serverApi.bean.exception.ApplicationException;
import com.zero.serverApi.bean.exception.BizExceptionEnum;
import com.zero.serverApi.service.system.UserService;
import com.zero.serverApi.bean.vo.result.Result;

import com.zero.serverApi.utils.MD5;
import com.zero.serverApi.utils.RandomUtil;
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
    public void register(@RequestBody User params) {
        User Account = userService.findByAccount(params.getUserName());
        if (Account != null) {
            throw new ApplicationException(BizExceptionEnum.USER_ALREADY_REG);
        } else {


            params.setSalt(RandomUtil.getRandomString(5));
            params.setPassWord(MD5.md5(params.getPassWord(),params.getSalt()));
            System.out.println(params);

            int insert = userService.insert(params);


            System.out.println(insert);
//            return Result.success(insert);
        }

    }

    /**
     * 删除用户
     *
     * @param params
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Object deleteUser(@RequestBody Map<Object, Integer> params) {
        int delete = userService.delete(params.get("id"));
        return Result.success(delete);
    }

    /**
     * 修改信息
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Object upDataUser(@RequestBody Map<Object, Object> params) {
        int update = userService.update(params);
        return Result.success(update);
    }


    /**
     * 查询用户信息
     *
     * @return
    //     */
//    @RequestMapping(value = "/userList", method = RequestMethod.GET)
//    public Object getUserList() {
//
////        PageHelper.startPage(2, 3);
////        List<User> userList = userService.select();
////        PageBean<User> userPageInfo = new PageBean<>(userList);
////
////        System.out.println(userList);
//
//        return Result.success(userPageInfo);
//    }


}
