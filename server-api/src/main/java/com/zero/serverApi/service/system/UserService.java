package com.zero.serverApi.service.system;

import com.zero.serverApi.bean.entity.system.User;
import com.zero.serverApi.mapper.system.UserMapper;
import com.zero.serverApi.service.CURDService;
import com.zero.serverApi.security.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class UserService implements CURDService {
    private Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    private UserMapper userMapper;

    @Value("${jwt.token.expire.time}")
    private Long tokenExpireTime;


    @Override
    public User findByAccount(String userName) {
        return userMapper.selectUser(userName);
    }

    @Override
    public int insert(User record) {
        return userMapper.insertUser(record);
    }


    /**
     * 根据用户信息生成token
     *
     * @param params
     * @return
     */
    public String loginForToken(User params) {

        //获取用户token值
        String token = JwtUtil.sign(params, tokenExpireTime * 60000);
        //将token作为RefreshToken Key 存到缓存中，缓存时间为token有效期的两倍
        String refreshTokenCacheKey = token;

        Date date = new Date(System.currentTimeMillis() + tokenExpireTime * 120000);


        logger.info("token:{}", token);
        return token;
    }


}
