package com.l7lsbu.team.exceptions;

public class CustomException extends RuntimeException{
    
    private static final long serialVersionUID = -5397384602980256665L;

    public CustomException(String message) {
        super(message);
    }
}
