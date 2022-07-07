package com.zero.server.controller;


import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/account")
public class AccountController {


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Object login(@RequestBody Map<Object, Object> params) {
        Object userName = params.get("userName");
        Object passWord = params.get("passWord");
        Map<Object, Object> map = new HashMap<>();
        map.put("token", "4564564564546");
        return map;
    }

}

