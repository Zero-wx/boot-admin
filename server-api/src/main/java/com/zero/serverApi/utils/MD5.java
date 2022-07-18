package com.zero.serverApi.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5 加密
 */
public class MD5 {
    public static final Logger LOG = LoggerFactory.getLogger(MD5.class);

    /**
     * 16进制字符集
     */
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /**
     * 循环次数
     */
    public final static int HASH_ITERATIONS = 1024;
    /**
     * 加盐参数
     */
    public final static String HASH_ALGORITHM_NAME = "MD5";


    /**
     * 加密工具类
     *
     * @return
     */
    public static String md5(String credentials, String salt) {
        MessageDigest messageDigest = null;

        try {
            messageDigest = MessageDigest.getInstance("MD5");

            messageDigest.reset();

            // 加盐
            messageDigest.update(salt.getBytes(StandardCharsets.UTF_8));
            // 再放需要被加密的数据
            messageDigest.update(credentials.getBytes(StandardCharsets.UTF_8));

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            System.out.println("NOSu.md加密");
        }


        byte[] digest = messageDigest.digest();
        StringBuffer md5StringBuff = new StringBuffer();

        for (int i = 0; i < digest.length; i++) {
            if (Integer.toHexString(0xFF & digest[i]).length() == 1) {
                md5StringBuff.append("0").append(Integer.toHexString(0xFF & digest[i]));
            } else {
                md5StringBuff.append(Integer.toHexString(0xFF & digest[i]));
            }
        }

        return md5StringBuff.toString();
    }


}
