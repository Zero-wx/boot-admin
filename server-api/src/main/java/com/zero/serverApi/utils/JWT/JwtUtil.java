package com.zero.serverApi.utils.JWT;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.zero.serverApi.bean.entity.system.Account;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.UUID;

public class JwtUtil {

    /**
     * 生成Token签名
     *
     * @return
     */
    public static String sign(Account account, long expireTime) {
        try {
            Date date = new Date(System.currentTimeMillis() + expireTime);
            Algorithm algorithm = Algorithm.HMAC256(account.getPassWord());

            return JWT.create()
                    .withClaim("userName", account.getUserName())
                    .withClaim("userId", account.getId())
                    .withClaim("uuid", UUID.randomUUID().toString())
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }
}
