package com.example.demo.apiException;

public class ApiException extends RuntimeException {
    public ApiException(String message) {
        super(message);
    }
}