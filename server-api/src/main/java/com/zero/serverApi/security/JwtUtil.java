package com.zero.serverApi.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.zero.serverApi.bean.entity.system.User;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.UUID;


/**
 * Token 类
 */
public class JwtUtil {


    /**
     * 生成签名
     *
     * @param user
     * @param expireTime
     * @return 加密token
     */
    public static String sign(User user, long expireTime) {

        try {


            Date date = new Date(System.currentTimeMillis() + expireTime);

            Algorithm algorithm = Algorithm.HMAC256(user.getPassWord());

            return JWT.create()
                    .withClaim("username", user.getUserName())
                    .withClaim("userId", user.getId())
                    .withClaim("uuid", UUID.randomUUID().toString())
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (UnsupportedEncodingException e) {
            return null;
        }

    }
}
