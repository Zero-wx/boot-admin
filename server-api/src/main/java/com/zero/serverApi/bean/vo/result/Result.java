package com.zero.serverApi.bean.vo.result;

public class Result {
    public static final Integer SUCCESS = 2000;
    public static final Integer FAILURE = 9999;
    public static final Integer TOKEN_EXPIRE = 50014;

    public static Results success(Object data) {
        return new Results(Result.SUCCESS, "成功", data);
    }

    public static Results failure(String msg) {
        return new Results(Result.FAILURE, msg, null);
    }

    public static Results expire() {
        return new Results(Result.TOKEN_EXPIRE, "token过期", null);
    }
}
