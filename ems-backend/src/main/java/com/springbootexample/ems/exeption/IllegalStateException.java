package com.springbootexample.ems.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.ALREADY_REPORTED)
public class IllegalStateException extends RuntimeException{
    public IllegalStateException(String message){
        super(message);
    }
}
