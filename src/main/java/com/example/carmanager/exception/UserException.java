package com.example.carmanager.exception;

public class UserException extends Exception{
    public UserException(String message) {
        super(message);
    }
    public static final String USER_NOT_FOUND = "User Not Found";
}
