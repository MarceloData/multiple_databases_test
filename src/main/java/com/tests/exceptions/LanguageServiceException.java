package com.tests.exceptions;

public class LanguageServiceException extends RuntimeException {

    public LanguageServiceException(String message) {
        super(message);
    }

    public LanguageServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
