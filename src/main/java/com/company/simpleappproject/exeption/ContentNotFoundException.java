package com.company.simpleappproject.exeption;

public class ContentNotFoundException extends RuntimeException {
    public ContentNotFoundException(String message){
        super(message);
    }
}
