package com.dio.challenge.exception;

public class ThereIsAlreadyGameException extends BusinessException {

    public ThereIsAlreadyGameException() {
    }

    public ThereIsAlreadyGameException(String message) {
        super(message);
    }

    public ThereIsAlreadyGameException(String message, Throwable cause) {
        super(message, cause);
    }

    public ThereIsAlreadyGameException(Throwable cause) {
        super(cause);
    }

    public ThereIsAlreadyGameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
