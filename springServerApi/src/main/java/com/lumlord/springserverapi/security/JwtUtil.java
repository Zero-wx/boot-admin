package com.lumlord.springserverapi.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.lumlord.springserverapi.pojo.Account;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.UUID;

public class JwtUtil {

    /**
     * 生成Token
     *
     * @param account    用户信息
     * @param expireTime 有效时长
     * @return Token
     */
    public static String sign(Account account, long expireTime) {
        try {
            Date date = new Date(System.currentTimeMillis() + expireTime);
            Algorithm algorithm = Algorithm.HMAC256(account.getPassword());
            return JWT.create()
                    .withClaim("username", account.getUsername())
                    .withClaim("userId", account.getId())
                    .withClaim("uuid", UUID.randomUUID().toString())
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    /**
     * 校验token是否正确
     *
     * @param token
     * @param username
     * @param password
     * @return true
     */
    public static boolean verify(String token, String username, String password) {
        JWTVerifier verifier = null;
        try {
            Algorithm algorithm = Algorithm.HMAC256(password);
            verifier = JWT.require(algorithm).withClaim("username", username).build();
            DecodedJWT verify = verifier.verify(token);
        } catch (UnsupportedEncodingException e) {
            return false;
        }
        return true;
    }


    public static String getUsername(String token) {
        try {
            DecodedJWT decode = JWT.decode(token);
            return decode.getClaim("username").asString();

        } catch (JWTDecodeException e) {
            return null;
        }
    }


}
