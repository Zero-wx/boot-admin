package com.zero.serverApi.utils.result;

public class Result {
    public static final Integer SUCCESS = 2000;
    public static final Integer FAILURE = 9999;
    public static final Integer TOKEN_EXPIRE = 50014;

    public static Results success(Object data) {
        return new Results(Result.SUCCESS, "成功", data);
    }


}
