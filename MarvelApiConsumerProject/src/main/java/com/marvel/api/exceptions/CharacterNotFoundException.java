package com.marvel.api.exceptions;

public class CharacterNotFoundException extends Exception {
    public CharacterNotFoundException(String msg) {
        super(msg);
    }
}
