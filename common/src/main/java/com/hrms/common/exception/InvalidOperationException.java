package com.hrms.common.exception;

public class InvalidOperationException extends BaseException{
    public InvalidOperationException(String message, Object... serviceName) {
        super(message, serviceName);
    }
    public InvalidOperationException() {
        super("无效操作");
    }
}
