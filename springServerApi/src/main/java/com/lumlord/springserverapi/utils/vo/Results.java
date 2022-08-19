package com.lumlord.springserverapi.utils.vo;

public class Results {
    public static final Integer SUCCESS = 20000;
    public static final Integer FAILURE = 9999;
    public static final Integer TOKEN_EXPIRE = 50014;


    public static Result<?> success(Object data) {
        return new Result<>(Results.SUCCESS, "成功", data);
    }

    public static Result<?> failure(String message) {
        return new Result<>(Results.FAILURE, message, null);
    }

    public static Result<?> success() {
        return new Result<>(Results.SUCCESS, "成功", null);
    }

    public static Result<?> expire(Object data) {
        return new Result<>(Results.TOKEN_EXPIRE, "Token 过期", null);
    }
}
