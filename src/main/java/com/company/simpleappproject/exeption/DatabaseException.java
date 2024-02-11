package com.company.simpleappproject.exeption;

public class DatabaseException extends RuntimeException{

    public DatabaseException(String message){
        super(message);
    }
}
