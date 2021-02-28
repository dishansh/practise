package com.marvel.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class InValidResponseFromMarvel extends RuntimeException{
    public InValidResponseFromMarvel(String msg){super(msg);}
}
