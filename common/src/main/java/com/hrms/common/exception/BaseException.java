package com.hrms.common.exception;

import lombok.Getter;

/**
 * 自定义异常基类
 */
@Getter
public abstract class BaseException extends RuntimeException {
    protected String message;
    protected Object serviceName;
    public BaseException(String message, Object... serviceName) {
        super(message);
        this.message = message;
        this.serviceName = serviceName.length > 0 ? serviceName[0] : null;
    }
}
