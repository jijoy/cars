package com.example.carmanager.exception;

public class CarsException extends  Exception{

    public static final String CARS_NOT_FOUND = "Cars Not Found";

    public CarsException(String message){
        super(message);
    }

}
