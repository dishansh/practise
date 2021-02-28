package com.marvel.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ApiCallingException extends Exception{
    public ApiCallingException(Throwable e){
        super(e);
    }
}
