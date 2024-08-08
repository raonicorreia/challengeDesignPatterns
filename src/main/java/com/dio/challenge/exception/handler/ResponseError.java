package com.dio.challenge.exception.handler;

public class ResponseError {

    private final Integer status;
    private final String error;
    private final String message;

    public ResponseError(Integer status, String error, String message) {
        this.status = status;
        this.error = error;
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }
}
