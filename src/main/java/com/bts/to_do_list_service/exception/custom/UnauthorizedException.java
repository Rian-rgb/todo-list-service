package com.bts.to_do_list_service.exception.custom;

public class UnauthorizedException extends RuntimeException {

    public UnauthorizedException() {
        super();
    }
    public UnauthorizedException(String message, Throwable cause) {
        super(message, cause);
    }
    public UnauthorizedException(String message) {
        super(message);
    }
    public UnauthorizedException(Throwable cause) {
        super(cause);
    }
}
