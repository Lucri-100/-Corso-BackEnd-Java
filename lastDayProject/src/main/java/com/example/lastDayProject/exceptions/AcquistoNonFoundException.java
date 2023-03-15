package com.example.lastDayProject.exceptions;

import com.example.lastDayProject.entities.Acquisto;

public class AcquistoNonFoundException extends Exception{
    String message;

    public AcquistoNonFoundException(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}