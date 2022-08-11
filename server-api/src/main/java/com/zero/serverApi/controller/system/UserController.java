package com.zero.serverApi.controller.system;


import com.zero.serverApi.bean.vo.result.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public Object userInfo() {
        return Result.success(null);
    }
}
