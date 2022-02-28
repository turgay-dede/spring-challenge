package com.turgaydede.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends RuntimeException{
    private final static String MESSAGE = "Müşteri bulunamadı";
    public CustomerNotFoundException(){
        super(MESSAGE);
    }
}
