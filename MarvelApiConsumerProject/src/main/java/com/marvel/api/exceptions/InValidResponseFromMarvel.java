package com.marvel.api.exceptions;

public class InValidResponseFromMarvel extends RuntimeException {
    public InValidResponseFromMarvel(String msg) {
        super(msg);
    }
}
