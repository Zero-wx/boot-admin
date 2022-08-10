//package com.zero.serverApi.security;
//
//import com.auth0.jwt.JWT;
//import com.auth0.jwt.algorithms.Algorithm;
//import com.auth0.jwt.exceptions.JWTDecodeException;
//import com.auth0.jwt.interfaces.DecodedJWT;
//import com.zero.serverApi.bean.entity.system.User;
//import com.zero.serverApi.utils.HttpUtil;
//
//import java.io.UnsupportedEncodingException;
//import java.util.Date;
//import java.util.UUID;
//
//
///**
// * Token 类
// */
//public class JwtUtil {
//
//
//    public static Long getUserId() {
//        return getUserId(HttpUtil.getToken());
//    }
//
//    public static Long getUserId(String token) {
//        try {
//            DecodedJWT jwt = JWT.decode(token);
//            return jwt.getClaim("userId").asLong();
//        } catch (JWTDecodeException e) {
//            return null;
//        }
//    }
//
//
//    /**
//     * 生成签名
//     *
//     * @param user
//     * @param expireTime
//     * @return 加密token
//     */
//    public static String sign(User user, long expireTime) {
//
//        try {
//
//
//            Date date = new Date(System.currentTimeMillis() + expireTime);
//
//            Algorithm algorithm = Algorithm.HMAC256(user.getPassWord());
//
//            return JWT.create()
//                    .withClaim("username", user.getUserName())
//                    .withClaim("userId", user.getId())
//                    .withClaim("uuid", UUID.randomUUID().toString())
//                    .withExpiresAt(date)
//                    .sign(algorithm);
//        } catch (UnsupportedEncodingException e) {
//            return null;
//        }
//
//    }
//}
