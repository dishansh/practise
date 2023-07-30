package com.marvel.api.exceptions;

public class ApiCallingException extends Exception {

    public ApiCallingException(Throwable e) {
        super(e);
    }

    public ApiCallingException( String message) {
        super(message);
    }
}
