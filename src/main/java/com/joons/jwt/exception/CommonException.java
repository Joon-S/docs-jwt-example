package com.joons.jwt.exception;

public class CommonException extends RuntimeException {

    private static final long serialVersionUID = -4650425057945535417L;
    private String message;

    public CommonException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
