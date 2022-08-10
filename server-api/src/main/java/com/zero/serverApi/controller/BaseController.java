package com.zero.serverApi.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * 基础controller
 */
public class BaseController {
    private static Logger logger = LoggerFactory.getLogger(BaseController.class);

//    /**
//     * 根据Token获取用户id
//     *
//     * @return
//     */
//    public Long getIdUser(HttpServletRequest request) {
//        String authorization = request.getHeader("Authorization");
//
//        Long idUser = JwtUtil.getUserId(authorization);
//
//        if (idUser == null) {
//            throw new RuntimeException("用户不存在");
//
//        }
//        return idUser;
//
//    }
}
