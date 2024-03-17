package com.example.n11_final_case.exception;

/*
 * @author batuhanvural
 */

public class CommentNotFoundException extends RuntimeException{
    public CommentNotFoundException(String message) {
        super(message);
    }
}
