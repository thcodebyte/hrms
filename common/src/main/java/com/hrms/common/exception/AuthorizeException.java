package com.hrms.common.exception;

public class AuthorizeException extends BaseException{
    public AuthorizeException(String message, Object... serviceName) {
        super(message, serviceName);
    }
}
