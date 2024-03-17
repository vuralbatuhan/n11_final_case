package com.example.n11_final_case.exception;

/*
 * @author batuhanvural
 */

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message){
        super(message);
    }

}
