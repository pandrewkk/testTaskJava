package com.andrey.demo.exception;

public class InitializationException extends RuntimeException {
    public InitializationException() {
    }

    public InitializationException(String message) {
        super(message);
    }
}
