package com.hrms.common.exception;

public class InvalidParameterException extends BaseException{
    public InvalidParameterException(String message, Object... serviceName) {
        super(message, serviceName);
    }
    public InvalidParameterException() {
        super("无效参数");
    }
}
