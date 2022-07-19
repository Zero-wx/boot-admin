package com.zero.serverApi.bean.exception;

/**
 * 业务错误异常枚举
 */
public enum BizExceptionEnum implements ServiceExceptionEnum {

    /**
     * 账户问题
     */
    USER_ALREADY_REG(401, "改用户已经被注册"),
    USER_NOT_EXISTED(400, "没有此用户");


    BizExceptionEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private Integer code;
    private String message;

    @Override
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
