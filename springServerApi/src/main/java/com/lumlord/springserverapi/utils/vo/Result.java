package com.lumlord.springserverapi.utils.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Result<T> {

    private Integer code;

    private String message;

    private T data;

    private boolean success;


    public Result() {
    }

    public Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.success = Results.SUCCESS.intValue() == code.intValue();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        stringBuilder.append("'code':").append(code).append(",");
        stringBuilder.append("'msg':").append(message).append(",");
        stringBuilder.append("'success':").append(success).append(",");
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
