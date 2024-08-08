package com.dio.challenge.exception;

public class InvalidGameException extends BusinessException {

    public InvalidGameException() {
    }

    public InvalidGameException(String message) {
        super(message);
    }

    public InvalidGameException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidGameException(Throwable cause) {
        super(cause);
    }

    public InvalidGameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
