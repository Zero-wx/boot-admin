package com.zero.serverApi.bean.vo.result;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Results<T> {
    private Integer code;
    private String message;
    private T data;
    private boolean success;


    public Results() {

    }

    public Results(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.success = Result.SUCCESS.intValue() == code.intValue();
    }


    @Override
    public String toString() {
        return "A{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                ", success=" + success +
                '}';
    }
}
