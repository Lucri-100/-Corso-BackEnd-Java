package com.example.lastDayProject.exceptions;

public class UtenteNonFoundException extends Exception{
    String message;

    public UtenteNonFoundException(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
