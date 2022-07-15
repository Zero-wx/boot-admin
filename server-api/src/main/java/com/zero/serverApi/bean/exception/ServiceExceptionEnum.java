package com.zero.serverApi.bean.exception;

/**
 * 异常抽象接口
 */
public interface ServiceExceptionEnum {
    /**
     * 异常编码
     */
    Integer getCode();

    /**
     * 异常消息
     */
    String getMessage();
}
