package com.lumlord.springserverapi.exception;

public interface ServiceExceptionEnum {
    /**
     * 获取异常编码
     *
     * @return
     */
    Integer getCode();

    /**
     * 获取异常信息
     *
     * @return
     */
    String getMessage();
}
