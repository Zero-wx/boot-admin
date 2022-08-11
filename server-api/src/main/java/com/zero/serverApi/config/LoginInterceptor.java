package com.zero.serverApi.config;


import com.zero.serverApi.bean.exception.ApplicationException;
import com.zero.serverApi.bean.exception.BizExceptionEnum;

import com.zero.serverApi.utils.StringUtil;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String tokenName = "Authorization";
        // 尝试从header中取token
        String token = request.getHeader(tokenName);
        System.out.println(token);

        boolean b = StringUtil.hasBlank(token);

        if (token == null) {
            throw new ApplicationException(BizExceptionEnum.USER_NOT_EXISTED);
        }
        return true;

    }
}
