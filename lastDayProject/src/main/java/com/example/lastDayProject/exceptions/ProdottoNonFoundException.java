package com.example.lastDayProject.exceptions;

import com.example.lastDayProject.entities.Prodotto;

public class ProdottoNonFoundException extends Exception{
    String message;

    public ProdottoNonFoundException(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
