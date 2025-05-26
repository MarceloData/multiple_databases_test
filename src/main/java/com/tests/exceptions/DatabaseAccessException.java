package com.tests.exceptions;

public class DatabaseAccessException extends RuntimeException {
    public DatabaseAccessException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
