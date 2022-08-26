package com.lumlord.springserverapi.exception;

/**
 * 异常枚举
 */
public enum ApplicationExceptionEnum implements ServiceExceptionEnum {

    /**
     * 账户问题
     */
    USER_ALREADY_REG(401, "该用户已经被注册，请重新输入");


    private Integer code;
    private String message;

    ApplicationExceptionEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

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
