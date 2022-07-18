package com.zero.serverApi.utils;

import java.util.Random;

/**
 * 获取随机字符串
 */
public class RandomUtil {
    public static String getRandomString(int length) {

        String base = "abcdefghijklmnopqrstuvwxyz0123456789";

        Random random = new Random();

        StringBuffer stringBuffer = new StringBuffer();

        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            stringBuffer.append(base.charAt(number));
        }
        return stringBuffer.toString();
    }
}
